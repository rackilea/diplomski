case R.id.spinner1:
    if(parent.getItemAtPosition(pos).toString().equals("--")){
        textView1.setTextColor(Color.RED);
    } else {
        textView1.setTextColor(Color.WHITE);
    }
    break;