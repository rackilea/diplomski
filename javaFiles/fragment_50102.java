package com.mss.sample;

import javax.xml.bind.annotation.XmlElement;

/**
 * Employee Model class
 * 
 * @author Anilkumar Bathula
 */


public class Employee {

    // Fields
    int empId;
    String empName;
    int empSal;

    public Employee(int empId, String empName, int empSal) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }

    @XmlElement
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @XmlElement
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @XmlElement
    public int getEmpSal() {
        return empSal;
    }

    public void setEmpSal(int empSal) {
        this.empSal = empSal;
    }

}