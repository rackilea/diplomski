import org.apache.commons.jxpath.JXPathContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 */
public class JXPather {
    public static void main(String[] args) {
        Department d = new Department();
        d.employees.add(new Employee(new Address("wherever a")));
        d.employees.add(new Employee(new Address("wherever b")));
        d.employees.add(new Employee(new Address("wherever c")));
        d.employees.add(new Employee(new Address("wherever def")));

        JXPathContext context = JXPathContext.newContext(d);
        // access matched xpath objects by iterating over them
        for (Iterator iterator = context.iterate("/employees/address/street"); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        // or directly via standard xpath expressions

        System.out.println("street of third employee is: "+context.getValue("/employees[3]/address/street"));

        // supports most (or all ?) xpath expressions

        for (Iterator iterator = context.iterate("/employees/address/street[string-length(.) > 11]"); iterator.hasNext();) {
            System.out.println("street length longer than 11 c'ars:"+iterator.next());
        }
    }

    static public class Department {
        List<Employee> employees = new ArrayList<Employee>();
        public List<Employee> getEmployees() {
            return employees;
        }
    }

    static public class Employee {
        Address address;
        Employee(Address address) {
            this.address = address;
        }
        public Address getAddress() {
            return address;
        }

    }

    static public class Address {
        String street;
        Address(String street) {
            this.street = street;
        }
        public String getStreet() {
            return street;
        }
    }

}