/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaxFunction;

import Employee.Employee;

/**
 *
 * @author kevin
 */
public class TaxFunction {

    /**
     * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
     * dibayarkan setahun.Pajak dihitung sebagai 5% dari penghasilan bersih
     * tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan
     * bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
     *
     * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak
     * kena pajaknya adalah Rp 54.000.000. Jika pegawai sudah menikah maka
     * penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000. Jika
     * pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah
     * sebesar Rp 4.500.000 per anak sampai anak ketiga.
     *
     * @param employee
     */
    public static int calculateTax(Employee employee) {

        int numberOfMonthWorking = employee.getEmployeeIdentity().getMonthWorkingInYear();
        int numberOfChildren = employee.getEmployeesFamily().getChildrens().size();
        boolean isMarried = !employee.getEmployeesFamily().getSpouse().getSpouseName().equals("");
        int monthlySalary = employee.getEmployeeFinance().getMonthlySalary();
        int otherMonthlyIncome = employee.getEmployeeFinance().getOtherMonthlyIncome();
        int deductible = employee.getEmployeeFinance().getAnnualDeductible();

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        return getFinalTax(isMarried, monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, numberOfChildren);

    }

    private static int getFinalTax(boolean isMarried, int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, int numberOfChildren) {
        int tax;
        if (isMarried) {
            tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (54000000 + 4500000 + (numberOfChildren * 4500000))));

        } else {
            tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));

        }
        if (tax < 0) {
            return 0;
        } else {
            return tax;
        }
    }
}
