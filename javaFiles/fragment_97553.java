import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class GuavaTest {

    public static void main(String ...args){

        Predicate<Customer> isVip = new Predicate<Customer>() {
            @Override
            public boolean apply(Customer customer) {
                return customer.isVip();
            }
        };

        Predicate<Customer> isConferenceAttendee = new Predicate<Customer>() {
            @Override
            public boolean apply(Customer customer) {
                return customer.isConferenceAttendee();
            }
        };

        List<Customer> customers = Lists.newArrayList();

        customers.add(new Customer("jim",true,false));
        customers.add(new Customer("bob",false,true));
        customers.add(new Customer("rob",true,true));

        System.out.println("Vips:\t"+Iterables.filter(customers, isVip));
        System.out.println("Vips && ConfAttendees:\t"+Iterables.filter(customers, Predicates.and(isVip,isConferenceAttendee)));
        System.out.print("Vips || ConfAttendees:\t"+Iterables.filter(customers, Predicates.or(isVip,isConferenceAttendee)));
    }
}

class Customer {
 private String name;
 private boolean vip;
 private boolean conferenceAttendee;

    Customer(String name, boolean vip, boolean conferenceAttendee) {
        this.name = name;
        this.vip = vip;
        this.conferenceAttendee = conferenceAttendee;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean isConferenceAttendee() {
        return conferenceAttendee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}