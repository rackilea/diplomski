public class MainActivity extends AppCompatActitvity implements LoginListener{
    ....
    // When you create the Login object, in onCreate() for example:
    // new Login(application, this); // this is the activity acting as listener...

    @Override public void onLoginPerformed(Boolean result){
        // do what you want to do with the result in Main Activity
    }

}