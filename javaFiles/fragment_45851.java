public MyFirstFragment extends Fragment {

public MyFirstFragment(){
//constructor - don't use this to create a new fragment directly
}

public static MyFirstFragment newInstance(String argument1, String argument2) {

    // This is where you set the Fragment arguments:

    MyFirstFragment instance = new MyFirstFragment();
    Bundle arguments = new Bundle();

    // add whatever arguments you need to the bundle
    arguments.putString("ARGUMENT_1_KEY", argument1);
    arguments.putString("ARGUMENT_2_KEY", argument2);

    //Set the arguments on the new fragment instance
    instance.setArguments(arguments);

    return instance;
}

// recover the values in onCreate:
@Override
public void onCreate(Bundle savedInstanceState) {

    // an easy way to check if this is a new instance is to null-check the saved state Bundle
    if (savedInstanceState == null) {
        String argument1 = getArguments().getString("ARGUMENT_1_KEY");
        String argument2 = getArguments().getString("ARGUMENT_2_KEY");
    } else {
        // restore whatever you need from savedInstanceState bundle
    }