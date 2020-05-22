int checked = 0;
Button gotIt;

void sendMessage(View v) {
gotIt = (Button)findViewById(R.id.got_it);

switch(checked) {
    case 0:
        gotIt.setBackgroundResource(R.drawable.checked_list);
        checked = 1;
        break;
    case 1:
        gotIt.setBackgroundResource(R.drawable.not_checked_list);
        checked = 0;
        break;
}
}