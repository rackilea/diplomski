List<Tag> combinedTags = Stream
        .concat( // combine streams
                tags.stream(),
                tagIds.stream().map(Tag::new) // assuming constructor with id parameter
        )
        .distinct() // get rid of duplicates assuming correctly implemented equals method in Tag
        .collect(Collectors.toList());