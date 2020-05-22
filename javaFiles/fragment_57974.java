final BroadcastReceiver receiver = new BroadcastReceiver() {
   @Override
   public void onReceive(Context context, Intent intent) {
      adapter.updateTimes();
   }
}

//Inside your Adapter...
void updateTimes() {
    for(int i = 0; i < notes.size(); i++) {
       final Note note = notes.get(i);
       //Pseudocode for determening whether or not an update it necessary
       //Actual implementation will depend on how you handle updates
       final String relative = getCurrentRelativeTimeString(); 
       if(!Objects.equals(relative, note.getRelativeTimeString())) {
           note.setRelativeTimeString(relative);
           notifyItemChanged(i);
       }
    }
}