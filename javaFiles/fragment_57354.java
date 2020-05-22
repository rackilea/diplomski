public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_fit_screen);

        b = (ImageView) findViewById(R.id.imageView3);
        t = (EditText) findViewById(R.id.editText38);
        u = (EditText) findViewById(R.id.editText39);

        selectImage();
    }

    public void selectImage() {

        final CharSequence[] options = { "Take Photo", "Choose from             Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(ImageFitScreen.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                   File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                   intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                   startActivityForResult(intent, 1);
                  }
                 else if (options[item].equals("Choose from Gallery"))
                  {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   startActivityForResult(intent, 2);
                   }
                   else if (options[item].equals("Cancel")) {
                   dialog.dismiss();
                   finish();
                   }
                   }
                     });
        builder.setOnKeyListener(new Dialog.OnKeyListener() {

        @Override
        public boolean onKey(DialogInterface dialog, int keyCode,
                KeyEvent event) {
            // TODO Auto-generated method stub
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                finish();
                dialog.dismiss();
            }
            return true;
        }
    });
        builder.show();

    }