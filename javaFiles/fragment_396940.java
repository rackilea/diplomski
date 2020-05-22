int[] myImageList = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6};

    Random random = new Random();
    int randomNumber = random.nextInt(myImageList.length);

    Picasso.with(getApplicationContext())
            .load(albumArtUri)
            .placeholder(R.drawable.no_album)
            .error(myImageList[randomNumber])
            .noFade()
            .resize(500, 0)
            .into(mAlbumArt);