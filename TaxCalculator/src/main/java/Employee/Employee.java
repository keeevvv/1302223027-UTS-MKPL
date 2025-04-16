/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import TaxFunction.TaxFunction;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class Employee {

    private EmployeeIdentity employeeIdentity;

    private EmployeeFinance employeeFinance;

    private EmployeesFamily employeesFamily;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.employeeIdentity = new EmployeeIdentity();
        this.employeeIdentity.setEmployeeId(employeeId);
        this.employeeIdentity.setFirstName(firstName);
        this.employeeIdentity.setLastName(lastName);
        this.employeeIdentity.setIdNumber(idNumber);
        this.employeeIdentity.setAddress(address);
        this.employeeIdentity.setYearJoined(yearJoined);
        this.employeeIdentity.setMonthJoined(monthJoined);
        this.employeeIdentity.setDayJoined(dayJoined);
        this.employeeIdentity.setIsForeigner(isForeigner);
        this.employeeIdentity.setGender(gender);

        this.employeeFinance = new EmployeeFinance();
        this.employeesFamily = new EmployeesFamily();

    }

    public void setMonthlySalary(int grade) {
        if (grade == 1) {
            employeeFinance.setMonthlySalary(3000000);
            if (employeeIdentity.getisForeigner()) {
                employeeFinance.setMonthlySalary((int) (3000000 * 1.5));
            }
        } else if (grade == 2) {
            employeeFinance.setMonthlySalary(5000000);
            if (employeeIdentity.getisForeigner()) {
                employeeFinance.setMonthlySalary((int) (5000000 * 1.5));
            }
        } else if (grade == 3) {
            employeeFinance.setMonthlySalary(7000000);
            if (employeeIdentity.getisForeigner()) {
                employeeFinance.setMonthlySalary((int) (700000 * 1.5));
            }
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.employeeFinance.setAnnualDeductible(deductible);
    }

    public void setAdditionalIncome(int income) {
        this.employeeFinance.setOtherMonthlyIncome(income);
    }

    public int getAnnualIncomeTax() {

        //Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate date = LocalDate.now();

        if (date.getYear() == employeeIdentity.getYearJoined()) {
            int monthWorkingInYear = date.getMonthValue() - employeeIdentity.getMonthJoined();
            employeeIdentity.setMonthWorkingInYear(monthWorkingInYear);
        } else {
            employeeIdentity.setMonthWorkingInYear(12);
        }

        return TaxFunction.calculateTax(employeeFinance.getMonthlySalary(), employeeFinance.getOtherMonthlyIncome(), employeeIdentity.getMonthWorkingInYear(), employeeFinance.getAnnualDeductible(), employeesFamily.getSpouse().equals(""), employeesFamily.getChildrens().size());
    }
}
