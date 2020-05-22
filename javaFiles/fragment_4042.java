public View getView(int postion,View contentView,ViewGroup parent)
{
    View item=inflater.inflate(R.layout.mag_listview,parent,false);

     new DisplayImageFromURL((ImageView) item.findViewById(R.id.imageView1))
     .execute(imgurl);

    TextView tv1=(TextView) item.findViewById(R.id.textView1);
    //TextView tv2=(TextView) item.findViewById(R.id.textView2);



    //creating the object of the student
    maginfo latestnews=getItem(postion);
    Log.d("latestnews", latestnews.getPdf());

    //populate the custom list view with the class of Student
    tv1.setText(latestnews.getTitle());
    //tv2.setText(latestnews.getImg());
   String image=latestnews.getImg();

    imgurl=imgstore+image;
    Log.d("imageurl", ""+imgurl);



    return item;    
}