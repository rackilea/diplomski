View itemView = mLayoutInflater.inflate(R.layout.view_item, parent, false);
    int height = screenWidth/2;
    int width = screenHeight*24/100;
    itemView.setMinimumHeight(height);
    itemView.setMinimumWidth(width );
    return new TextViewHolder(itemView);