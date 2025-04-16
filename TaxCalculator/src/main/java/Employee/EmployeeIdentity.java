/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import Enum.Gender;
import java.time.LocalDate;

/**
 *
 * @author kevin
 */
public class EmployeeIdentity {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private boolean isForeigner;
    private Gender gender;
    private LocalDate joinDate;
    private int monthWorkingInYear;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }

    public boolean isIsForeigner() {
        return isForeigner;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public int getMonthWorkingInYear() {
        return monthWorkingInYear;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIsForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setMonthWorkingInYear(int monthWorkingInYear) {
        this.monthWorkingInYear = monthWorkingInYear;
    }

}
