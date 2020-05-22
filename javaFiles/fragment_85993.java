public class tryClass
{
    // here, non-static variable v will be instantiated
    // as an array with a length of one, holding the value 0 in it's one slot;
    // it will be instantiated when an instance of tryClass is created.
    int[] v = {0};

    // here, this tryClass has another tryClass named "obj" in it as one of its fields.
    tryClass obj;

    public void met ()
    {
        // here, the tryClass's tryClass obj is instantiated
        // and this second tryClass's "v" is instantiated
        // and then it's one slot is set to 30.
        obj = new tryClass();
        obj.v[0] = 30;

        // now, the first tryClass's "v" is set to 3.
        v[0]=3;
    }

    public static void main (String[] args)
    {
        // creating a new tryClass.  This is NOT the same object as in met.
        // But it CONTAINS the same object in met.
        // You could call it by going obj.obj.
        tryClass obj = new tryClass(); // is this the SAME object as in met() ?  Answer: No.

        // this does nothing, it just creates another int[] v
        // that exists only inside the main() method.  It is not
        // the same as obj.v!
        int[] v = new int[1];

        // changing the contents of obj.v, but not reassigning obj.v itself.
        obj.v[0] = 40;

        // calling met, which will change obj.v's contents again, but not reassign it.
        obj.met();
    }
}