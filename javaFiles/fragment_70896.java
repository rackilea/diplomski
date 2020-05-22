public void initializeButtonClickListener(){
    this.button.setOnClickListener(new View.OnClickListener() {
        @Override
        onClick(){
             notifyDataSetChanged();
        }
    });
}