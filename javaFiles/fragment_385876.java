void startImageActivity(String imgUrl)
    {
    Intent intent = new Intent(context,ViewImage.class);
    intent.putExtra("profilePic",imgUrl);
    context.startActivity(intent);
    }