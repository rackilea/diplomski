String fragmentToDisplay = getIntent.getStringExtra("fragmentToDisplay");
switch (fragmentToDisplay) {
    case FirstActivity.FRAGMENTA:
        //FragmentTransaction to show Fragment A
        break;
    case FirstActivity.FRAGMENTB:
        //FragmentTransaction to show Fragment B
        break;
    case FirstActivity.FRAGMENTC:
        //FragmentTransaction to show Fragment C
        break;
}