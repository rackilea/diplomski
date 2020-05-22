public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final int VIEW_TYPE_MESSAGE = 0;
    final int VIEW_TYPE_IMAGE = 1;

    Context context;
    List<ChatWrapper> messages;
    List<ImageDataWrapper> images;

    public ChatAdapter(Context context, List<ChatWrapper> messages, List<ImageDataWrapper> images){
        this.context = context;
        this.messages = messages;
        this.images = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(viewType == VIEW_TYPE_MESSAGE){
            return new MessageViewHolder(itemView);
        }

        if(viewType == VIEW_TYPE_IMAGE){
            return new ImageViewHolder(itemView);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position){
        if(viewHolder instanceof MessageViewHolder){
            ((MessageViewHolder) viewHolder).populate(messages.get(position));
        }

        if(viewHolder instanceof ImageViewHolder){
            ((ImageViewHolder) viewHolder).populate(images.get(position - messages.size()));
        }
    }

    @Override
    public int getItemCount(){
        return messages.size() + images.size();
    }

    @Override
    public int getItemViewType(int position){
        if(position < messages.size()){
            return VIEW_TYPE_MESSAGE;
        }

        if(position - messages.size() < images.size()){
            return VIEW_TYPE_IMAGE;
        }

        return -1;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        TextView timeStamp;
        ImageView userImage;

        public MessageViewHolder(View itemView){
            super(itemView);

            message = (TextView) itemView.findViewById(R.id.Single_Item_Chat_Message);
            timeStamp = (TextView) itemView.findViewById(R.id.Single_Item_Chat_TimeStamp);
            userImage = (ImageView) itemView.findViewById(R.id.Single_Item_Chat_ImageView);
        }

        public void populate(ChatWrapper chatWrapper){
            message.setText(chatWrapper.getMessage());
            userImage.setText(chatWrapper.getTimestamp());
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView dataTitle;
        TextView dataLink;
        TextView dataSnippet;
        ImageView image;
        ImageButton dataSendButton;

        public ImageViewHolder(View itemView){
            super(itemView);

            dataTitle = (TextView) itemView.findViewById(R.id.Image_data_Title);
            dataLink = (TextView) itemView.findViewById(R.id.Image_data_Link);
            dataSnippet = (TextView) itemView.findViewById(R.id.Image_data_Snippet);
            image = (ImageView) itemView.findViewById(R.id.Image_data_Image);
            dataSendButton = (ImageButton) itemView.findViewById(R.id.Image_data_SendButton);
        }

        public void populate(ImageDataWrapper imageDataWrapper){
            dataTitle.setText(imageDataWrapper.getPage_Title());
            dataLink.setText(imageDataWrapper.getPage_Link());
            dataSnippet.setText(imageDataWrapper.getPage_Desc());
            Picasso.with(context).load(imageDataWrapper.getPage_ImageThumb()).into(image);
        }
    }
}