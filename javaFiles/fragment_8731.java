public class Test{


    public String modifiedString()
    {
        Main main = Main.getInstance();
        //so with main.something.. you can call the methods you want
        //a good solution is to make a singleton class only for MyAsyncTask setting the
        //functions get/set so you can take the values from other classes


        return "modified " + main.pulledFromAsyncTask() + "\n";

    }

    }