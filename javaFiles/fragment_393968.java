RelativeLayout container = (RelativeLayout)findViewById(R.id.mylayout);  //this will be your container layout
for (int i = 0; i < secQAArr.size(); i++){

    View item = getLayoutInflater().inflate(R.layout.item, null);
    TextView tQue = (TextView) findViewById(R.id.que);
    que.seText(secQAArr.get(i)[0]);
    TextView tAns = (TextView) findViewById(R.id.ans);
    que.seText(secQAArr.get(i)[1]);
    container.addView(item);
}