package com.mss.sample;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Employees class
 * 
 * @author Anilkumar Bathula
 */

@XmlRootElement
public class Employees {
    private List<Employee> employees;

    public Employees() {
        employees = new ArrayList<Employee>();
    }

    @XmlElement
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}