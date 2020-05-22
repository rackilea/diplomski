package Super;

    public class SuperConstructorCall {

    protected SuperConstructorCall() {
    }

}

package Child;

import Super.SuperConstructorCall;

public class ChildCall extends SuperConstructorCall
{

    public static void main(String[] args) {

        SuperConstructorCall s = new SuperConstructorCall(){}; // This will work as the access is by an anonymous class instance creation expression 
    }
}