package kz.base;
import java.util.Scanner;

public class Assignment1 {
	/**
	*	Даны два целых положительных числа произвольной длины. Вывести сумму этих
	*	чисел. В решении нельзя использовать BigInteger.
	*	Ввод чисел через stdin (standard input). Предусмотреть наличие юнит теста.
	*/

	private static String arg1;
	private static String arg2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arg1 = sc.next();
		arg2 = sc.next();
		String result = sumBigValues(arg1, arg2);
		System.out.println(result);
	}

	public static String sumBigValues(String s1, String s2) {
		if (s1.length() > s2.length()) {
			s2 = makeStringLengthEqualToAnother(s1, s2);
		} else {
			s1 = makeStringLengthEqualToAnother(s2, s1); 
		}

		StringBuilder result = new StringBuilder(s1);

		int overflow = 0;

		for (int i=s1.length() - 1; i>=0; i--) {
			int tempIntValueA = 0;
			int tempIntValueB = 0;
			if (Character.isDigit( s1.charAt(i) )) {
				Character c1 = s1.charAt(i);
          		String s1_ = c1.toString();
				tempIntValueA = Integer.parseInt(s1_);
			}

			if (Character.isDigit( s2.charAt(i) )) {
				Character c2 = s2.charAt(i);
          		String s2_ = c2.toString();
				tempIntValueB = Integer.parseInt(s2_);
			}
			int sumValues = tempIntValueA + tempIntValueB + overflow;
			if (sumValues > 19) {
				overflow = 2;
				result.setCharAt(i, Character.forDigit(( sumValues % 10), 10) ) ;
			} else if (sumValues > 9) {
				overflow = 1;
				result.setCharAt(i, Character.forDigit(( sumValues % 10), 10) ) ;
			} else {
				overflow = 0;
				result.setCharAt(i, Character.forDigit( sumValues , 10) ) ;
			}

		}

		if (overflow > 0) {
			result = new StringBuilder(String.valueOf(overflow)).append(result);
		}
		return result.toString();
	}

	private static String makeStringLengthEqualToAnother(String longStr, String shortStr) {
		int deltaLength = longStr.length() - shortStr.length();
		String zero = "0";
		shortStr = new String(new char[deltaLength]).replace("\0", zero) + shortStr;
		return shortStr;
	}

	public void setArg1(String s1) {
		this.arg1 = s1;
	}
	public void setArg2(String s2) {
		this.arg2 = s2;
	}
	public String getArg1() {
		return this.arg1;
	}
	public String getArg2() {
		return this.arg2;
	}
}