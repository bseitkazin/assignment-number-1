package kz.base;

import org.junit.Assert;
import org.junit.Test;

public class Assignment1Test {
	
	@Test
	public void test() {
		Assignment1 obj = new Assignment1();
		obj.setArg1("99");
		obj.setArg2("2");
		String result = obj.sumBigValues(obj.getArg1(), obj.getArg2());
		Assert.assertEquals(result, "101");
	}
}