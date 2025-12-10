package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeSalaryCalculatorTest 
{

	
	@Test
	public void testSalaryCalculator() 
	{
		//working hours <= Standard hours
		assertEquals(54000,EmployeeSalaryCalculator.salaryCalculator(36, 1500));
		assertEquals(60000,EmployeeSalaryCalculator.salaryCalculator(40, 1500));
	}
	
	@Test
	public void testSalaryCalculator1() 
	{
		//working hours > standard hours
		assertEquals(114000,EmployeeSalaryCalculator.salaryCalculator(58, 1500));
	}

}
