/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.taxcalculator;

import Employee.Employee;
import Enum.Gender;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author kevin
 */
public class TaxCalculator {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LocalDate joinDate = LocalDate.of(2024, Month.MARCH, 12);
        Employee employee = new Employee("1", "first", "last", "999", "addres", joinDate, true, Gender.FEMALE);
        employee.setMonthlySalary(1);
        employee.setAnnualDeductible(8774);
        employee.setAdditionalIncome(4444);
        System.out.println(employee.getAnnualIncomeTax());
    }
}
