import java.util.Scanner;
class test
{
    public static void main(String[] args)
    {
        // let Myarray and Myarray2 hold max 5 element
        emp[] Myarray = new emp[5]; // salary grater than 500 
        emp[] Myarray2 = new emp[5]; // salary less than 500

        // initialize Myarray[0] before 'using' it else it will rise Null Pointer Exception
        Myarray[0] = new emp()
        Myarray[0].set_name("Saif");
        Myarray[0].set_id(2014106);
        Myarray[0].set_salary(155);

        // initialize Myarray[1] before 'using' it else it will rise Null Pointer Exception
        Myarray[1] = new emp()
        Myarray[1].set_name("sara");
        Myarray[1].set_id(2014100);
        Myarray[1].set_salary(155);

        // initialize Myarray[2] before 'using' it else it will rise Null Pointer Exception
        Myarray[2] = new emp()
        Myarray[2].set_name("ahmad");
        Myarray[2].set_id(2014101);
        Myarray[2].set_salary(155);

        // initialize Myarray[3] before 'using' it else it will rise Null Pointer Exception
        Myarray[3] = new emp()
        Myarray[3].set_name("rawan");
        Myarray[3].set_id(2014103);
        Myarray[3].set_salary(155);

        // initialize Myarray[4] before 'using' it else it will rise Null Pointer Exception
        Myarray[4] = new emp()
        Myarray[4].set_name("khalil");
        Myarray[4].set_id(2014104);
        Myarray[4].set_salary(155);

        // Move iteration here as you only need it after you set the content of each element
        for(int i = 0; i<Myarray.length; i++)
        {
            if (Myarray[i].get_salary() < 500)
            {
                // Get emp from current array
                emp x = Myarray[i];
                // create new object for Myarray2[i] here before 'using' it else it will rise Null Pointer Exception
                Myarray2[i] = new emp();
                Myarray2[i].set_name(x.get_name());
                Myarray2[i].set_id(x.get_id());
                Myarray2[i].set_salary(x.get_salary());

                // since you say Myarray only hold salary greater than 500, i assume you need to remove it here.
                Myarray[i] = null;
            }
        }

        // EDIT: show the content
        for(int i = 0; i<Myarray.length; i++)
        {
            if (Myarray[i] != null)
            {
                // print here, for example
                System.out.println("name " + Myaarray[i].get_name());
            }
        }

        // the same goes for Myarray2
        for(int i = 0; i<Myarray2.length; i++)
        {
            if (Myarray2[i] != null)
            {
                // print here, for example
                System.out.println("name " + Myaarray2[i].get_name());
            }
        }
    } 
}