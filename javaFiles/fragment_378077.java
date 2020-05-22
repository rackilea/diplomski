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

        SuperConstructorCall s = new SuperConstructorCall(); // Compile time error saying SuperConstructorCall() has protected access in SuperConstructorCall
    }
}