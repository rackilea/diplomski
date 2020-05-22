String search = "ABC".toLowerCase();
    String word = "ABCDE<br>XYZABC";
    String[] keywords = word.split("<br>");
    int count = 0;

    for (String keyword : keywords) {
        if (keyword.toLowerCase().contains(search)) {
            ++count;
            endText = keyword;
        }
    }

    if (count > 1) {
        definition.setText(endText + " More");
    }
    else if (count == 1) {
        definition.setText(endText);
    }