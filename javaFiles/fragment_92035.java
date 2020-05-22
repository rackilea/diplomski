@Override
    public int getItemViewType(int position) {
        Chat chat = this.getItem(position);
        if(chat.isSent()){
           return 0;
         }else{
           return 1;
         }
    }