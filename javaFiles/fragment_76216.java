//
    // Define a collator for German language
    //
    Collator collator = Collator.getInstance(Locale.GERMAN);

    //
    // Sort the list using Collator
    //
    Collections.sort(words, collator);