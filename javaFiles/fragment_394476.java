public class MyOwnOnClickListener implements OnClickListener{
TextView id2;

    // MainActivity caller;
    public MyOwnOnClickListener(TextView id2) {
        this.id2 = id2;
    }

    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.produceText1:
            id2.setText("fgdsgdfhgdfh");
            break;
        // Other cases here...
        default:
            // Whatever you want to manage the situation...
        }
    }
}