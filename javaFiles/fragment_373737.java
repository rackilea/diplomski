public View getView(int position, View convertView, ViewGroup parent) {
. . .
  final Cmd cmd = (Cmd) getItem(position);

    holder.txtSuccess.setText(cmd.getVideoName());
    holder.txtSuccess.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            run(cmd);
        }
    });
. . .
}

public void run(Cmd cmd) {
    Intent intent = new Intent(context, ViewVideo.class);
    String txt=cmd.getVideoURL(); 
    intent.putExtra("videofilename", txt);
    context.startActivity(intent);
}