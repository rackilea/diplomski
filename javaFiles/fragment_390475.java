public void onActivityResult(int requestCode, int resultCode, Intent data)
{
    if (requestCode == code) {
        if (resultCode == RESULT_OK) {

            // Toast.makeText(this, data.getData().toString(),
            //Toast.LENGTH_SHORT).show();
            a = data.getStringExtra("n1");

            num = Integer.parseInt(a);
            t.setText("" + num);
            c = data.StringExtra("n2");
            num1 = Integer.parseInt(c);
            t.setText("" + num1);
            int total = num1 + num;

        }
    }
}