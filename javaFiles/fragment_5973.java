Optional<Note> bestNote = notes.stream()
                               .map(note -> new Together(note, composer.evaluate(note)))
                               .sorted(new CompareTogetherByBadness())
                               .limit(notes.size() / 2) // Taking the top half
                               .sorted(new CompareTogetherByGoodness())
                               .findFirst() // Assuming the last comparator sorts in descending order
                               .map(Together::getNote);