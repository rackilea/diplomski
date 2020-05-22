String noteVersion = "2017-11-23T15:25:20.154+00:00";
    String updatedNoteVersion = "2017-11-23T15:25:22+00:00";

    OffsetDateTime created = OffsetDateTime.parse(noteVersion);
    OffsetDateTime updated = OffsetDateTime.parse(updatedNoteVersion);
    if (updated.isAfter(created)) {
        System.out.println("PASSED");
    } else {
        System.out.println("FAILED");
    }