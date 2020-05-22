String timestampFromSharedPreferences = mySharedPrefs.getString(KEY, null);
    long diffInSeconds = Duration.between(Instant.parse(timestampFromSharedPreferences),
                                            Instant.now())
            .getSeconds();
    if (diffInSeconds < 120) {
        System.out.println("Less than 120");
    }