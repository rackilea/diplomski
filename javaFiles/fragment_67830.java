Boolean first = false, second = false;


      @Override
            public void onClick(View v) {
                first = true;
                chooseImage();
            }
        });

        photoUpload2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            second = true;
                chooseImage();
            }
        });
    }

    private void chooseImage() {
        Intent openGalleryIntent = new Intent();
        openGalleryIntent.setType("image/*");
        openGalleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(openGalleryIntent, "Select Picture"), GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                if(first)
                {
                    imageView.setImageBitmap(bitmap);
                    first = false;
                }else if(second)
                {
                 imageView2.setImageBitmap(bitmap);
                 second = false;
                 }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }