@Override
public View getView(int position, View convertView, ViewGroup parent) {

  // If we weren't given a view, inflate one
  if (convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.my_list, null);
    }                       

    LinearLayout mLinearLayout = (LinearLayout)convertView.findViewById(R.id.my_list_linearLayout);
    TextView[] strings = new TextView[mMyStringArray.size()];

        // Create TextView
        strings[position] = new TextView(getActivity());
        strings[position].setText(mMyStringsArray(i));
        strings[position].setId(position + 5);
        mLinearLayout.addView(strings[position]);
    }
    return convertView;
  }