/**
* The Callable<V> interface allows you to define a Object V that you will
* return. In this case we are returning the integer object wrapper Integer
*/
public class BilSpil implements Callable<Integer> {
Scanner input = new Scanner(System.in);
/**
*Since we defined our class to implement Callable<Integer> we have to override
* the abstract method V call() throws Exception, and in our case it is of 
*the type Integer
*/
@Override
public Integer call() throws Exception {
     /**
     *input.nextInt() will block and not return untill a integer is entered 
     * java autoboxes the int primitive to its wrapper class Integer automagically
     */
    return input.nextInt();
}