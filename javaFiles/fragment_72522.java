@Override
public int getViewTypeCount() {
    return 2;
}

@Override
public int getItemViewType(int position) {
     Cursor c = (Cursor)getItem(position);
     Message m = Message.getMessage(context, c);
     switch(m.getType()){
         case Message.MMS_IN: // 128
             return 1;
         case Message.MMS_OUT: // 132
             return 0;
         case Message.SMS_IN: // 2
             return 1;
         case Message.SMS_OUT: // 1
             return 0;
         default:
             return 0;
      }
}