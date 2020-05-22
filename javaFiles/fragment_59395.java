public abstract class ActivityUtils extends AppCompatActivity{

    public static void addFragment(FragmentManager manager, Fragment fragment, int frameId){
        performTask(manager, fragment, frameId, 1);
    }

    public static void changeFragment(FragmentManager manager, Fragment fragment, int frameId){
        performTask(manager, fragment, frameId, 2);
    }

    private static void performTask(FragmentManager manager, Fragment fragment, int frameId, int taskType) {
        FragmentTransaction transaction = manager.beginTransaction();

        switch(taskType){
            case 1:
                transaction.add(frameId, fragment);
                break;
            case 2:
                transaction.replace(frameId, fragment);
                break;
        }

        transaction.addToBackStack(null);
        transaction.commit();
    }

}