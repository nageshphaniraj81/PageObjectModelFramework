package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogicTest {
	
	@Test
	public void Test1(){	
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void Test2(){	
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void Test3(){	
		Assert.assertEquals(true, true);
	}
}
