public void onClickbutton2(View v) 
    {

        /*----------------------------------phone number catcher------------------*/
        Intent i = new Intent(this, Contacts.class);   //<-- Declare your Intent variable here.
        String text = _field.getText().toString();
        Pattern pt = Pattern.compile("\\d{5,11}");
        Matcher m = pt.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group()).append(",");
        }
        String[] phones = sb.toString().split(",");

        i.putExtra("phones", phones);   //<-- add Phone number to intent

        /*------------------------------------------------email catcher-----------*/

        String email = _field.getText().toString();
        String EMAIL_PATTERN="^.+@.+\\..+$";

        Pattern pp = Pattern.compile(EMAIL_PATTERN);
        Matcher e = pp.matcher(email);
        StringBuilder sc = new StringBuilder();
        while (e.find()) {
            sc.append(e.group()).append(",");
        }
        String[] emails = sc.toString().
        i.putExtra("emails", emails);    //<-- add email to Intent
        startActivity(i);

    }