@Override
public View getView(int position, View convertView, ViewGroup parent) {

  // If we weren't given a view, inflate one
  if (convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.my_list, null);
    }                       

    LinearLayout mLinearLayout = (LinearLayout)convertView.findViewById(R.id.my_list_linearLayout);
    TextView tv = (TextView) convertView.findViewById(R.id.someID) //where someID is the id you give the TextView in your layout file


        tv.setText(mMyStringsArray(position));
        tv.setId(position + 5);  // Shouldn't need this now
    }
    return convertView;
  }