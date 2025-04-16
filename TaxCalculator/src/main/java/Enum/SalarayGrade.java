/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enum;

/**
 *
 * @author kevin
 */
public enum SalarayGrade {
    GRADE1(3000000),
    GRADE2(5000000),
    GRADE3(7000000);

    private int salary;

    SalarayGrade(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

}
