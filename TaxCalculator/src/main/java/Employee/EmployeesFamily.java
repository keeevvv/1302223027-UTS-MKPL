/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class EmployeesFamily {

    private EmployeeSpouse spouse;

    private List<EmployeeChildren> Childrens;

    public EmployeesFamily() {
        this.Childrens = new LinkedList<EmployeeChildren>();
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        EmployeeSpouse spouse = new EmployeeSpouse();
        spouse.setSpouseIdNumber(spouseIdNumber);
        spouse.setSpouseName(spouseName);
        this.spouse = spouse;
    }

    public void addChild(String childName, String childIdNumber) {
        EmployeeChildren child = new EmployeeChildren();
        child.setChildIdNumber(childIdNumber);
        child.setChildNames(childName);
        Childrens.add(child);
    }

    public EmployeeSpouse getSpouse() {
        return spouse;
    }

    public List<EmployeeChildren> getChildrens() {
        return Childrens;
    }

}
