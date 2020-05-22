btnEmailForm.setOnClickListener(new View.OnClickListener() {
        @Override
                     public void onClick(View view) {

            final Intent ei = new Intent(Intent.ACTION_SEND_MULTIPLE);
            ei.setType("plain/text");
            ei.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]{"myemail.edu"});
            ei.putExtra(android.content.Intent.EXTRA_SUBJECT, "Testing");
            ei.putExtra(android.content.Intent.EXTRA_TEXT, "Here is another test email");

            File f = new File(Environment.getExternalStorageDirectory().toString());
            for (File temp : f.listFiles()) {
                if (temp.getName().equals("temp.jpg")) {
                    f = temp;
                    break;
                }
            }
            f.setReadable(true, false);                     // This allows external program access
            Uri U = Uri.fromFile(f);
            ArrayList<Uri> uris = new ArrayList<Uri>();
            uris.add(U);

            File fi = new File(Environment.getExternalStorageDirectory().toString());
            for (File tempe : fi.listFiles()) {
                if (tempe.getName().equals("myData.txt")) {
                    fi = tempe;
                    break;
                }
            }


            Uri Us = Uri.fromFile(fi);
            uris.add(Us);



            ei.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
            startActivityForResult(Intent.createChooser(ei, "Sending multiple attachment"), 12345);