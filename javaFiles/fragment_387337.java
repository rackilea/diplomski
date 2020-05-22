AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
myAlert.setMessage("SeekBar")
        .setView(mView)
        .setTitle("Title")
        .setIcon(R.drawable.ic_launcher)
        .create();
myAlert.show();