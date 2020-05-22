package com.sandbox;

import org.apache.commons.beanutils.BeanUtils;

public class Sandbox {

    public static void main(String[] args) {
        try {
            Employee e = new Employee();
            e.setName("A");
            Employee y = new Employee();
//  y=e;
            BeanUtils.copyProperties(y, e);
            e.setName("B");
            System.out.println(y.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class Employee {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}