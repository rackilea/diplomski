ArrayList<View> viewList=new ArrayList<>();
initLayouts(){
    layout1 = (RelativeLayout)findViewById(R.id.layout1);
    layout2 = (RelativeLayout)findViewById(R.id.layout2);
    layout3 = (RelativeLayout)findViewById(R.id.layout3);
    layout4 = (RelativeLayout)findViewById(R.id.layout4);
    layout5 = (RelativeLayout)findViewById(R.id.layout5);


    viewList.add(layout1);
    viewList.add(layout2);
    viewList.add(layout3);
    viewList.add(layout4);
    viewList.add(layout5);

    for(int i=0;i<viewList.size();i++){
        viewList.get(i).setVisibility(View.GONE);
    }

button.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v){
        loadRandomLayout();
    }
});
}
public loadRandomLayout(){
    if(viewList.size()>0) {
        Random r = new Random();
        int number = r.nextInt(viewList.size());
        viewList.get(number).setVisibility(View.VISIBLE);
        viewList.remove(number);
    }else{
        startActivity(new Intent(this,NewActivity.class));
    }
}