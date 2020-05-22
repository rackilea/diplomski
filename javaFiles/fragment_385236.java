public AvailableTaskListAdapter(List<Task> taskList, List<String> keys, Context mContext, FirebaseFirestore firestore) {
//                                                                ^^^^
    this.taskList = taskList;
    this.keys = keys; //Intialize the the second list
    this.mActivity = (Activity) mContext;
    this.firestore = firestore;
}