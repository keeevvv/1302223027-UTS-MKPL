/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import Enum.Gender;
import Enum.SalarayGrade;
import TaxFunction.TaxFunction;
import java.time.LocalDate;

/**
 *
 * @author kevin
 */
public class Employee {

    private EmployeeIdentity employeeIdentity;

    private EmployeeFinance employeeFinance;

    private EmployeesFamily employeesFamily;

    public EmployeeIdentity getEmployeeIdentity() {
        return employeeIdentity;
    }

    public EmployeeFinance getEmployeeFinance() {
        return employeeFinance;
    }

    public EmployeesFamily getEmployeesFamily() {
        return employeesFamily;
    }

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate joinDate, boolean isForeigner, Gender gender) {
        this.employeeIdentity = new EmployeeIdentity();
        this.employeeIdentity.setEmployeeId(employeeId);
        this.employeeIdentity.setFirstName(firstName);
        this.employeeIdentity.setLastName(lastName);
        this.employeeIdentity.setIdNumber(idNumber);
        this.employeeIdentity.setAddress(address);
        this.employeeIdentity.setJoinDate(joinDate);
        this.employeeIdentity.setIsForeigner(isForeigner);
        this.employeeIdentity.setGender(gender);

        this.employeeFinance = new EmployeeFinance();
        this.employeesFamily = new EmployeesFamily();
        this.employeesFamily.setSpouse("", "");

    }

    public void setMonthlySalary(SalarayGrade grade) {
        int salary = grade.getSalary();
        if (employeeIdentity.isIsForeigner()) {
            salary = (int) (salary * 1.5);

        }

        employeeFinance.setMonthlySalary(salary);
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

        if (date.getYear() == employeeIdentity.getJoinDate().getYear()) {
            int monthWorkingInYear = date.getMonthValue() - employeeIdentity.getJoinDate().getMonthValue();
            employeeIdentity.setMonthWorkingInYear(monthWorkingInYear);
        } else {
            employeeIdentity.setMonthWorkingInYear(12);
        }

        return TaxFunction.calculateTax(this);
    }
}
