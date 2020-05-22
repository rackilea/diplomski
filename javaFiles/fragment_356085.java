public class TicketAdapter extends ArrayAdapter<TicketModel> implements View.OnClickListener{

    private ArrayList<TicketModel> dataSet;
    Context mContext;

    // View lookup cache
    private class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtTempsRestant;
        TextView txtDate;
        TextView txtSLA;
        ImageView info;
        RelativeLayout layout;

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                System.out.println("handler");

                Bundle bundle = msg.getData();
                long timeLeftMS = bundle.getLong("time");
                int hour = (int) ((timeLeftMS / (1000*60*60)) % 24);
                int minute = (int) ((timeLeftMS / (60000)) % 60);
                int seconde = (int)timeLeftMS % 60000 / 1000;

                String timeLeftText = "";

                if (hour<10) timeLeftText += "0";
                timeLeftText += hour;
                timeLeftText += ":";
                if (minute<10) timeLeftText += "0";
                timeLeftText += minute;
                timeLeftText += ":";
                if (seconde<10) timeLeftText += "0";
                timeLeftText += seconde;

                txtTempsRestant.setText(timeLeftText);
            }
        };

        public void startTimer(long timeLeftMS) {
            CountDownTimer countDownTimer = new CountDownTimer(timeLeftMS, 1000) {

                @Override
                public void onTick(long l) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("time", l);
                    Message message = new Message();
                    message.setData(bundle);
                    handler.sendMessage(message);
                }

                @Override
                public void onFinish() {

                }
            }.start();
        }

      }


    public TicketAdapter(ArrayList<TicketModel> data, Context context) {
        super(context, R.layout.row_item_ticket, data);
        this.dataSet = data;
        this.mContext=context;
        //startUpdateTimer();
    }


    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        TicketModel TicketModel=(TicketModel)object;

        switch (v.getId())
        {
            case R.id.item_info:

                Snackbar.make(v, "is Late? : " +TicketModel.isTicketEnRetard(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TicketModel TicketModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_ticket, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.titreTV);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.dateTV);
            viewHolder.txtSLA = (TextView) convertView.findViewById(R.id.slaTV);
            viewHolder.txtTempsRestant = (TextView) convertView.findViewById(R.id.SLARestantTV);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.layout = (RelativeLayout) convertView.findViewById(R.id.backgroundRow);


            result=convertView;
viewHolder.startTimer(Long.valueOf(TicketModel.getTempsRestantTicket()));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(TicketModel.getTitreTicket());
        viewHolder.txtDate.setText(TicketModel.getDateTicket());
        viewHolder.txtSLA.setText(TicketModel.getSlaTicket());
        //viewHolder.txtTempsRestant.setText(TicketModel.getTempsRestantTicket());
        viewHolder.info.setImageResource(getIconUrgence(TicketModel.getUrgenceTicket()));
        viewHolder.layout.setBackgroundColor(getColorBG(TicketModel.isTicketEnRetard()));
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);

        System.out.println("Here : "+TicketModel.getTitreTicket()); //getting each item's name
        System.out.println("Time = "+TicketModel.getTempsRestantTicket()); //getting each item's time left and it's correct    

        // Return the completed view to render on screen
        return convertView;
    }

    private int getColorBG(boolean ticketEnRetard) {
        int color;

        if (ticketEnRetard){
            color = Color.parseColor("#3caa0000");
        }
        else{
            color = Color.parseColor("#ffffff");
        }
        return color;
    }



    private int getIconUrgence(String urgenceTicket) {
        int icon;

        if((urgenceTicket.equals("Très basse"))||(urgenceTicket.equals("Basse"))){
            icon = R.drawable.basse;
        }
        else if((urgenceTicket.equals("Haute"))||(urgenceTicket.equals("Très haute"))){
            icon = R.drawable.haute;
        }
        else {
            icon = R.drawable.moyenne;
        }

        return icon;
    }


}