public void onListItemClick(ListView parent,View v,int position,long id){
try {
    TextView t4=(TextView)v.findViewById(R.id.No);

    if (t4!=null){
        BeanClass/*ClassName*/  mSelected;
        int idx=position;
        mSelected=m_adapter.getItem(idx);           
        String ActionID=mSelected.getID();

        Intent intent=new Intent(this,SoneActivity.class);
        intent.putExtra("StrStatus", StrStatus);
        startActivity(intent);
    }
}