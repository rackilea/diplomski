private ArrayList<CheckListSource > itemsData;

public ChildListAdapter(Activity activity, ArrayList<ChildListResponse> baseResponse) {
    this.itemsData = baseResponse;
    this.activity = activity;
}