public class PlanRecyclerAdapter extends RecyclerView.Adapter<PlanRecyclerAdapter.PlanViewHolder> {

private List<PlanRecycler> planList;
private boolean isDone[];
private int count = 0;
private List<String> current_workout = new ArrayList<>();
private String Plan_Name;
private Context context;

private Dbhelper dbhelper;
SQLController dbcon;
private SQLiteDatabase database;
public String rest = "";


public PlanRecyclerAdapter(List<PlanRecycler> planList, boolean isDone[], int count, String Plan_Name, Context context, Dbhelper dbhelper, SQLController dbcon, SQLiteDatabase database) {
    this.planList = new ArrayList<>();
    this.planList.addAll(planList);
    this.isDone = isDone;
    this.count = count;
    this.Plan_Name = Plan_Name;
    this.context = context;
    this.dbhelper = dbhelper;
    this.dbcon = dbcon;
    this.database = database;
}

@Override
public PlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_adapter_cell, parent, false);
    return new PlanViewHolder(itemView);
}

@Override
public void onBindViewHolder(PlanViewHolder holder, int position) {

    PlanRecycler addWorkout = planList.get(position);
    holder.Day_Holder.setText("Day " + (position + 1));
    holder.Workout_Name.setText(" - " + addWorkout.getPlan_Workout_Title());
    rest = addWorkout.getPlan_Workout_Title();

    current_workout.add(addWorkout.getPlan_Workout_Title());
    holder.Item_View.setOnClickListener(new OnClickListener() {//set the click listener
        @Override
        public void onClick(View v) 
        {
            // add code here
        }
    });
}

@Override
public int getItemCount() {
    return planList.size();
}

public class PlanViewHolder extends RecyclerView.ViewHolder {

    protected TextView Workout_Name;
    protected TextView Day_Holder;
    protected View Item_View;//add item view to PlanViewHolder 

    public PlanViewHolder(View itemView) {
        super(itemView);

        Typeface Roboto_Medium = Typeface.createFromAsset(itemView.getResources().getAssets(), "Roboto-Medium.ttf");
        Typeface Roboto_Regular = Typeface.createFromAsset(itemView.getResources().getAssets(), "Roboto-Regular.ttf");
        Item_View = itemView;//set item view
        Day_Holder = (TextView) itemView.findViewById(R.id.plan_day_holder_id);
        Day_Holder.setTypeface(Roboto_Regular);

        Workout_Name = (TextView) itemView.findViewById(R.id.plan_workout_title);
        Workout_Name.setTypeface(Roboto_Medium);

    }
}
}