itemView.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){
        int index = //get image index
        EventBus.getDefault().post(new ImageSelectedEvent(index));
    }
});