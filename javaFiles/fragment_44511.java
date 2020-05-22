public View getView(int position, View convertView, ViewGroup parent)
{
  if(convertView==null)
    convertView = inflater.inflate(R.layout.row_tweet, parent, false);

  Tweet t = tweetsList.get(position);

  ***TextView title = (TextView) convertView.findViewById(R.id.tweetTitle);***
  TextView body = (TextView) convertView.findViewById(R.id.tweetBody);

  title.setText(t.getTitle());
  body.setText(t.getBody());

  return convertView;
}