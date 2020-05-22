try {
    for (lineCount = 0; scanner.nextLine() != null; ) {
        if(!readString.trim().equals("")) lineCount++; // updated one
    }
} catch (NoSuchElementException e) {
    result.put(file, lineCount);
    totalLineCount += lineCount;
}