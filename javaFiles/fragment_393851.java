Intent groupLoadIntent;

public LoadGroupUser(Activity mActivity){
    this.activity = mActivity;
    groupLoadIntent = new Intent(activity, GroupActivity.class);
}