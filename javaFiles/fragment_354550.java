if (messageUser.getText().equals(FirebaseAuth.getInstance().getCurrentUser().getDisplayName())){                
 messageBubble.setBackgroundResource(R.drawable.active_user_message_background);
}
else{
    messageBubble.setBackgroundResource(R.drawable.normal_message_background);
}