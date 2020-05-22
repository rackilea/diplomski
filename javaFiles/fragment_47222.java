public void run(String txt) {

    Intent intent = new Intent(context, ViewVideo.class);
    intent.putExtra("videofilename",txt);
    context.startActivity(intent);
}