public class UserList extends BaseAdapter
{
    private Context mContext;
    private ArrayList<Employee> items;

    public UserList(Context c, ArrayList<Employee> items) 
    {
        this.mContext = c;
        this.items = items;
    }

        public int getCount() {
        return this.items.size();
    }

    public Object getItem(int position) {
        return this.items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View child, ViewGroup arg2) {
    Holder mHolder;
    LayoutInflater layoutInflater;
    if (child == null) {
        layoutInflater = (LayoutInflater)   mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        child = layoutInflater.inflate(R.layout.listcell, null);
        mHolder = new Holder();

        //mHolder.txt_id = (TextView) child.findViewById(R.id.txt_id);
        mHolder.txt_fName = (TextView) child.findViewById(R.id.txt_fName);
        mHolder.txt_lName = (TextView) child.findViewById(R.id.txt_lName);
        mHolder.txt_userName = (TextView) child.findViewById(R.id.txt_userName);

        child.setTag(mHolder);
    } else {
        mHolder = (Holder) child.getTag();
    }

    Employee employee = this.items.get(pos);

    ArrayList<String> employeeInfo = new ArrayList<String>();
    employeeInfo.add(employee.employeeId);
    employeeInfo.add(employee.firstName);
    employeeInfo.add(employee.lastName);

    mHolder.Details.setTag(employeeInfo);

    mHolder.txt_fName.setText(employee.firstName + " " + employee.lastName);    
    mHolder.txt_userName.setText(employee.emailId);

    return child;
}

public class Holder 
{
    //TextView txt_id;
    TextView txt_fName;
    TextView txt_lName;
    TextView txt_userName;
    Button Details;
}
}