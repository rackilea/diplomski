@Override
public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setDataAndType(Uri.parse("https://youtu.be/jxoG_Y6dvU8"), "video/*");

        startActivity(Intent.createChooser(intent, "Complete action using"));


}