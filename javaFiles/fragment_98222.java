public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView chatText;
        public CircleImageView chatImage;


        public MessageViewHolder(View itemView) {
            super(itemView);

          chatText =itemView.findViewById(R.id.chatText);
          chatImage=itemView.findViewById(R.id.chatImage);
        }


    }