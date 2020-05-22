private void setContentMessage(String theMessage,Context context)
    {

        View contentView = contxet.getLayoutInflater().inflate(R.layout.dialog_content, null);

        TextView titleMessage = (TextView) contentView.findViewById(R.id.title_message);
        titleMessage.setText(theMessage);
    }