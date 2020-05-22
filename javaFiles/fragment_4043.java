public View getView(int postion,View contentView,ViewGroup parent)
    {
    View item=inflater.inflate(R.layout.mag_listview,parent,false);

    //creating the object of the student
    maginfo latestnews=getItem(postion);
    Log.d("latestnews", latestnews.getPdf());
    String image=latestnews.getImg();
    imgurl=imgstore+image;

     new DisplayImageFromURL((ImageView) item.findViewById(R.id.imageView1))
     .execute(imgurl);

    TextView tv1=(TextView) item.findViewById(R.id.textView1);
    tv1.setText(latestnews.getTitle());

    return item;    
}