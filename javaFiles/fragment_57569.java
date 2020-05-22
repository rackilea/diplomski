public class VoteListAdapter extends BaseAdapter {

    private final String TAG = "*** VoteListAdapter ***";
    private Context context;
    private ArrayList<Vote> votes;

    public VoteListAdapter(Context context,ArrayList<Vote> votes) {
        this.context =context;
        this.votes =votes;

    }

    @Override
    public int getCount() {
        return votes.size();
    }

    @Override
    public Object getItem(int position) {
        return votes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder      = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.row, null);
            holder.tvName      = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvComment   = (TextView) convertView.findViewById(R.id.tvComment);
            holder.tvDate      = (TextView) convertView.findViewById(R.id.tvDate);
            holder.ratingBar   = (RatingBar)convertView.findViewById(R.id.ratingBar);
            holder.sharebtn   = (Button) convertView.findViewById(R.id.sharebtn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(votes.get(position).getName());
        holder.tvComment.setText(votes.get(position).getComment());
        holder.tvDate.setText(getFormatedDate(votes.get(position).getPublishDate()));
        holder.ratingBar.setRating(Integer.parseInt(votes.get(position).getRate()));
        holder.sharebtn.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,votes.get(position).getComment());
                try {
                    context.startActivity(Intent.createChooser(i, "Share"));
                } catch (android.content.ActivityNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
        return convertView;
    }




    private String getFormatedDate(String date) {
        String myDate = null;

        try {
            Date oldDate = new SimpleDateFormat("yy-mm-dd hh:mm:ss").parse(date);
            myDate = new SimpleDateFormat("dd MMM yyyy").format(oldDate);
        } catch (ParseException e) {
            myDate = "";
            e.printStackTrace();
        }

        return myDate;
    }



    static class ViewHolder {
        Button sharebtn;
        TextView  tvName;
        TextView  tvComment;
        TextView  tvDate;
        RatingBar ratingBar;
    }
}

public class FragmentComment extends Fragment {

    private final String TAG = "FragmentComment";

    private OnSendingRequestToServer onRequestToServer;
    private Context context;
    private Spinner spinner;
    private ListView listView;
    private List<Vote> voteList;
    private VoteListAdapter listAdapter;
    int ab = 1;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onRequestToServer = (OnSendingRequestToServer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnConnectingToServer interface.");
        }

        context = activity.getApplicationContext();

        Log.d(TAG, "Fragment attached to activity.");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        final TextView refresh = (TextView) view.findViewById(R.id.closetag);
        refresh.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                //  ActionBar actionBar = context.getSupportActionBar();
                //getSupportActionBar();
                //  actionBar.hide(); 


                //android.app.ActionBar bar = getActivity().getActionBar();
                //bar.hide();
                if (ab == 1){
                    ab = 0;
                    refresh.setText("کوچک کردن");
                    spinner.setVisibility(View.GONE);
                    android.app.ActionBar bar = getActivity().getActionBar();
                    bar.hide();
                }else{
                    ab = 1;
                    refresh.setText("تمام صفحه");
                    spinner.setVisibility(View.VISIBLE);
                    android.app.ActionBar bar = getActivity().getActionBar();
                    bar.show();
                }

            }
        });

        //  TextView tvComment = (TextView) view.findViewById(R.id.tvComment);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {




            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String deviceId = "all";

                voteList.clear();

                if(pos == 1){
                    //deviceId = getDeviceId();
                    deviceId = "c1";
                }else if(pos == 2){
                    deviceId = "c2";
                }else if(pos == 3){
                    deviceId = "c3";
                }else if(pos == 4){
                    deviceId = "c4";
                }else if(pos == 5){
                    deviceId = "c5";
                }else if(pos == 6){
                    deviceId = "c6";
                }else if(pos == 7){
                    deviceId = "c7";
                }else if(pos == 8){
                    deviceId = getDeviceId();
                }
                voteList.clear();
                new RequestVoteTask(deviceId).execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        listView = (ListView) view.findViewById(R.id.listView);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        voteList = new ArrayList<Vote>();
    }

    private String getDeviceId() {
        return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
    }



    /*----------------------------------------------------------------------------
     * This method is responsible for creating another thread in parallel with
     * main UI thread in order to send a request to server and get data (if any).
     * ---------------------------------------------------------------------------*/
    public class RequestVoteTask extends AsyncTask<Void, Void, Boolean> {
        String deviceId;

        RequestVoteTask(String deviceId) {
            this.deviceId = deviceId;
        }

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "RequestVoteTask is about to start...");

            onRequestToServer.DisplayLoding(true);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            boolean status = false;
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL(LinkManager.getCommentAPI(deviceId));
                Log.d(TAG, "Try to open: " + url.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();
                Log.d(TAG, "Response code is: " + responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    if (in != null) {
                        StringBuilder strBuilder = new StringBuilder();
                        // Read character by character              
                        int ch = 0;
                        while ((ch = in.read()) != -1)
                            strBuilder.append((char) ch);

                        // get returned message and show it
                        String response = strBuilder.toString();
                        Log.d("Server response:", response);

                        JSONObject jObject = new JSONObject(response);
                        JSONArray jsonArray = jObject.getJSONArray("posts");
                        for(int i=0; i<jsonArray.length(); i++){
                            Vote vote = new Vote();
                            vote.setDeviceId(jsonArray.getJSONObject(i).getString("DeviceId"));
                            vote.setName(jsonArray.getJSONObject(i).getString("FullName"));
                            vote.setRate(jsonArray.getJSONObject(i).getString("Rate"));
                            vote.setComment(jsonArray.getJSONObject(i).getString("Comment"));
                            vote.setPublishDate(jsonArray.getJSONObject(i).getString("PublishTime"));

                            voteList.add(vote);
                        }

                        if(voteList.size() >= 1)
                            status = true;
                    }

                    in.close();
                }
            }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }

            return status;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            Log.d(TAG, "RequestVoteTask finished its task.");

            onRequestToServer.DisplayLoding(false);

            if(!result)
                Toast.makeText(context, "جکی موجود نیست", Toast.LENGTH_LONG).show();

//          for(int i=0; i<voteList.size(); i++)
//              Log.d("Item " + i, voteList.get(i).toString());
            listAdapter = new VoteListAdapter(context,voteList);
            listView.setAdapter(listAdapter);
        }
    }
}