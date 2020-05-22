final Dialog    seekDialog = new Dialog(this);
seekDialog.setContentView(R.layout.opacity_chooser);
final TextView  seekTxt =    (TextView)seekDialog.findViewById(R.id.opq_txt);
final SeekBar seekOpq = (SeekBar)seekDialog.findViewById(R.id.seek);
Toast.makeText(getApplicationContext(),
            "start.", Toast.LENGTH_SHORT).show();
seekDialog.setTitle("Opacity level:");
seekOpq.setMax(100);
-------------------