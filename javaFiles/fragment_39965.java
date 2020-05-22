public class MessagingAdapter extends ArrayAdapter<MessagingObject> {


private static final String userID = "USERID";
private static final int TYPE_ITEM1 = 0;
private static final int TYPE_ITEM2 = 1;

public String newid;
public Context context;
public ArrayList<MessagingObject> object = new ArrayList<MessagingObject>();

int type;

public MessagingAdapter(Context context, int textViewResourceId, ArrayList<MessagingObject> objects) {
    super(context, textViewResourceId, objects);
    this.context = context;
    this.object = objects;
}

@Override
public int getItemViewType(int position) {

    if (userID.equals(newid)) {
        return = TYPE_ITEM1;
    } else {
        return = TYPE_ITEM2;
    }
}

@Override
public int getViewTypeCount() {

    return 2;
}

@Override
public View getView(int position, View convertview, ViewGroup parent) {


    MessagingObject i = object.get(position);
    newid = i.getMessageID();

    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if (getItemViewType(position) == TYPE_ITEM1) {
       convertview = inflater.inflate(R.layout.messagesright_layout, null);
       TextView sentmessage = (TextView) convertview.findViewById(R.id.messagesent_text);
       sentmessage.setText(object.get(position).getMessage());

       TextView senttime = (TextView) convertview.findViewById(R.id.messagesentTime);
       String senttimestring = new String().valueOf(object.get(position).getTimeStamp());
       senttime.setText(senttimestring);

      } else {
       convertview = inflater.inflate(R.layout.messages_layout, null);
       TextView message = (TextView) convertview.findViewById(R.id.message_text);
       message.setText(object.get(position).getMessage());

       TextView time = (TextView) convertview.findViewById(R.id.messageTime);
       String timestring = new String().valueOf(object.get(position).getTimeStamp());
       time.setText(timestring);
     }
    return convertview;