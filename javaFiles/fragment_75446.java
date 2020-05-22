package org.company;
import java.util.ArrayList;
import java.util.List;
public class Manager extends Employee {
    public List<Employee> subordinates ;
    public Manager() {
        subordinates = new ArrayList<Employee>();
    }
}