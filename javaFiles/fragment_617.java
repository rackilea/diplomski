char[] letters = word.toCharArray(); // no need to trim()

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != '*') {
                // Capitalize the first non-asterisk (even if that doesn't change it)
                letters[i] = Character.toUpperCase(letters[i]);
                // No need to look any further
                break;
            }
        }
        // That's it for capitalizing!