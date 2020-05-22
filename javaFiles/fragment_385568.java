public TaskListAdapter(Context context,ArrayList<Task> values)
{
    super(context,-1,values);
    this.dbHelper = new DatabaseHelper(context.getApplicationContext());
    this.context = context;
    this.values = values;
}