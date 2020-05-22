interface MyCustomJobExecutor {}

public class MyFragment extends Fragment implements MyCustomJobExecutor {/*...*/}

public class MyService extends Service implements MyCustomJobExecutor {
    //...
    public void checkUpdate(MyCustomJobExecutor jobExecutor, ...) {
        if (jobExecutor instanceof MyFragment) {
            // Manual code execution here
        } else { // Automatic code execution stuff }
    }
    //...
}