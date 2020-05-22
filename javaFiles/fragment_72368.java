@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_patient_home_screen, menu);


        menu.add(0, 1, 1, menuIconWithText(getResources().getDrawable(R.mipmap.user_2), getResources().getString(R.string.action_profile)));
        menu.add(0, 2, 2, menuIconWithText(getResources().getDrawable(R.mipmap.add_user), getResources().getString(R.string.action_add_user)));
        menu.add(0, 3, 3, menuIconWithText(getResources().getDrawable(R.mipmap.switch_profile), getResources().getString(R.string.action_switch_profile)));
        menu.add(0, 4, 4, menuIconWithText(getResources().getDrawable(R.mipmap.logout), getResources().getString(R.string.action_sign_out)));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(PatientHomeScreen.this, "Profile is Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(PatientHomeScreen.this, "Add New User is Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(PatientHomeScreen.this, "Switch Profile is Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case 4:
                Toast.makeText(PatientHomeScreen.this, "Sign Out is Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private CharSequence menuIconWithText(Drawable r, String title) {

        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }