public insertFavorite(Movie favorite) {
        ContentValues args = new ContentValues();
        args.put(TITLE, favorite.getTitle());
        args.put(ORIGINAL_TITLE, favorite.getOriginalTitle());
        args.put(RATING, favorite.getRating());
        args.put(RELEASE_DATE, favorite.getReleaseDate());
        args.put(OVERVIEW, favorite.getOverview());
        args.put(PHOTO_LINK, favorite.getPhotoLink());

        if (isDataAvailable(favorite.getTitle())) {
            database.update(DATABASE_TABLE, args, "title = " + favorite.getTitle(), null);
        } else {
            database.insert(DATABASE_TABLE, null, args);
        }

    }