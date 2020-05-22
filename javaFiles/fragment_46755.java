@Override
  public boolean onLongClick(View v) {
    if (listener!=null) {
      listener.onStartDrag();
    }

    ClipData clip=ClipData.newRawUri(title.getText(), videoUri);
    View.DragShadowBuilder shadow=new View.DragShadowBuilder(thumbnail);

    itemView.startDrag(clip, shadow, Boolean.TRUE, 0);

    return(true);
  }