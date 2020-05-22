final ViewHolder viewHolder;
if (view == null) {
    viewHolder = new ViewHolder();
    ...
    viewHolder.txtName = (TextView) view.findViewById(R.id.songName_text);
    viewHolder.txtSinger = (TextView) view.findViewById(R.id.singer_text);
    viewHolder.playB = (ImageView) view.findViewById(R.id.play_png);
    viewHolder.stopB = (ImageView) view.findViewById(R.id.stop_png);
    view.setTag(viewHolder);
} else {
    viewHolder = (ViewHolder) view.getTag();
}