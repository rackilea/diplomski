public class TaskAdapter implements ListAdapter, View.OnClickListener {

Context                 context;

List<Task>              tasks;
Task data;

// View adapterView;
public TaskAdapter(Context context, List<Task> tasks) {
    super();
    this.context = context;
    this.tasks = tasks;
} ...



@Override
public View getView(int position, View convertView, ViewGroup parent) 
{
    data = tasks.get(position);
    Button task_menu_bt = (Button)root.findViewById(R.id.taskMenuButton);

        task_menu_bt.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
                **//     How to access current Task data??  i can not do tasks.get(position)**
            }
        });

final Task data = tasks.get(position);