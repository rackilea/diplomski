@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    /**
     * check the type of view and return holder
     */
    if (viewType == MessageType.SENT_TEXT) {
        return new SentTextHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_sent, parent, false));
    } else if (viewType == MessageType.SENT_IMAGE) {
        return new SentImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_sent_img, parent, false));
    } else if (viewType == MessageType.RECEIVED_TEXT) {
        return new ReceivedTextHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_recieved, parent, false));
    } else if (viewType == MessageType.RECEIVED_IMAGE) {
        return new ReceivedImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_received_img, parent, false));
    }

    return null; // This shouldn't return null in any case or error 
                 // will be thrown.

}