mAsyncTaskFireDB.get_chat_message(params[0], new OnChatMsgreadFStoredB() {
  @Override
  public List<Chat_Message> onMsgreadCompleteFstoredB(List<Chat_Message> chat_messages) {
      Chat_Message[] msgarray = new Chat_Message[chat_messages.size()];
      for(Integer i=0;i<chat_messages.size();i++)
      {
        msgarray[i] = chat_messages.get(i);
      }
      new DBTask(msgarray).execute();
      return null;
  }
});

class DBTask extends AsyncTask<Void,Void, Void> {
    Chat_Message[] msgarray;
    public DBTask(Chat_Message[] data){
      msgarray = data;
    }

    @Override
    protected Void doInBackground(Void ...voids) {
       mCat_messageDao.insertAll(msgarray);
    }
}