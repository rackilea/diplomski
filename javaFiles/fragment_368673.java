//  loading album cover using Glide library
        String artist_id = (c.getString(c
                .getColumnIndex(MediaStore.Audio.Artists._ID)));
        Cursor albs = albums.getArtistsAlbumcursor(mContext, artist_id);
        String stralbumId=null;
        if(albs!=null && albs.moveToFirst()){
           stralbumId= albs.getString(albs.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
        }
        Uri ImageUrl = plist.getAlbumUri(mContext, stralbumId);
        if (ImageUrl != null) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(ImageUrl)
                    .into(image);
        }
    }