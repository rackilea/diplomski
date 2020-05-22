imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {               


                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_GALLERY);


            }
        });

public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            Uri uri = data.getData();  
            try {
                bitmap = Media.getBitmap(this.getContentResolver(), uri);
                 resize = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false);
                 imageView.setImageBitmap(resize);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }