public void onClick(View v) {
    if (counter >= 0) {
        counter--;
        textView1.setText("" + counter);
    } else if (counter == 0){
        button1.setImageResource(R.id.yourdrawable);
        counter--;
    }
}