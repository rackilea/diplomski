package com.mss.sample;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.mss.sample.Employees;

/**
 * Marshal class
 * 
 * @author Anilkumar Bathula
 */

public class Marshal {

    public static void main(String[] args) throws Exception {

        JAXBContext contextObj = JAXBContext.newInstance(Employees.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try {

            Employees employees = new Employees();
            Employee emp1 = new Employee(1, "Vimal Jaiswal", 50000);
            Employee emp2 = new Employee(2, "Kamal", 40000);

            employees.getEmployees().add(emp1);
            employees.getEmployees().add(emp2);
            marshallerObj.marshal(employees, new FileOutputStream(
                    "D:\\employee.xml"));

        } catch (JAXBException e) {
            System.out.println(e);
        }
    }
}