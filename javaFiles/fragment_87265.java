public class MyCustomMenuInstance { 

    // Member fields..

    public MyCustomMenuInstance() {
        // Init stuff.
    }

    public void onPrepareOptionsMenu(Menu menu) {
        // Do things..
        // Maybe you want to modify a variable in the Activity 
        // class? Well, pass an instance as an argument and create
        // a method for it in your Activity class.
    }

    public void onOptionsItemSelected(MenuItem i) {
        // Do things..
        // Maybe you want to modify a variable in the Activity 
        // class? Well, pass an instance as an argument and create
        // a method for it in your Activity class.
    }

}