public class AdapterForNamesListInUpcoming extends 
RecyclerView.Adapter<AdapterForNamesListInUpcoming.SingleItemRowHolder> {

private List<SingleItemModelForUpcoming> itemsList;
private List<SingleItemforPhoneNumbers> itemforPhoneNumbers;
private ArrayList<UpcomingObject> item;
private Context ctx;


public AdapterForNamesListInUpcoming(Context 
context,ArrayList<UpcomingObject> item,  List<SingleItemforPhoneNumbers> 
itemforPhoneNumbers , List<SingleItemModelForUpcoming> itemsList ) {
this.itemsList = itemsList;
this.item = item;
this.itemforPhoneNumbers = itemforPhoneNumbers;
this.ctx = context;
}


@Override
public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
View v = 
LayoutInflater.from(viewGroup.getContext())
.inflate(R.layout.upcomingclientlistlayout, null);
SingleItemRowHolder rh = new SingleItemRowHolder(v);
return rh;

}

@Override
public void onBindViewHolder(SingleItemRowHolder holder, int i) {

 SingleItemModelForUpcoming singleItem = itemsList.get(i);

SingleItemforPhoneNumbers singleItemforPhoneNumbers = 
itemforPhoneNumbers.get(i);

holder.nameofclient.setText(singleItem.getName());

holder.phoneNumber.setText(singleItemforPhoneNumbers.getPhoneNumber());
}

@Override
public int getItemCount() {
return (null != itemsList ? itemsList.size() : 0);
 }

public class SingleItemRowHolder extends RecyclerView.ViewHolder implements 
View.OnClickListener {

protected TextView nameofclient , phoneNumber, date;
public SingleItemRowHolder(View view) {
    super(view);

    this.nameofclient = (TextView) view.findViewById(R.id.nameofclient);
    this.phoneNumber = (TextView)view.findViewById(R.id.phoneNumber);
    view.setOnClickListener(this);
 }

 @Override
 public void onClick(View v) {
    // get data of first adapter
    UpcomingObject up = item.get(getAdapterPosition);

    Intent UpcomingDetailPage = new Intent(v.getContext(), 
  com.allwaseet.spaservshop.UpcomingDetailsPage.UpcomingDetailPage.class);
    v.getContext().startActivity(UpcomingDetailPage);
    String finalPhoneNumber = phoneNumber.getText().toString();
    Log.d("PhoneNumber from databse ","phone Number is "+finalPhoneNumber);

    SharedPreferences.Editor PhoneNumberEditor;
    SharedPreferences PhoneNumberSharedPreference;

    PhoneNumberSharedPreference = 
 ctx.getSharedPreferences("SelectedPhoneNumber", Context.MODE_PRIVATE);
    PhoneNumberEditor = PhoneNumberSharedPreference.edit();
    PhoneNumberEditor.putString("SelectedPhoneNumber",finalPhoneNumber);
    PhoneNumberEditor.commit();

    Log.d("PhoneNumber from databse ","phone Number is "+finalPhoneNumber);

    LayoutInflater inflater = LayoutInflater.from(ctx);
    View view = inflater.inflate(R.layout.upcominglayout, null, true);
    TextView textView = (TextView)view.findViewById( R.id.date );
    String finaldate = textView.getText().toString();
    Log.d("ss","date     is "+finaldate);

    SharedPreferences.Editor DateEditor;
    SharedPreferences DateSharedPreference;


    DateSharedPreference = ctx.getSharedPreferences("DateInUpcoming", 
    Context.MODE_PRIVATE);
    DateEditor = DateSharedPreference.edit();
    DateEditor.putString("DateInUpcoming",finaldate);
    DateEditor.commit();
   // return view;
    }
  }
 }