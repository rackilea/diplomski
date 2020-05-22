String userSplitToRemoveLastPart(String Y) {
    // Find the last space
    int lastSpace = Y.lastIndexOf(" ");

    // Return only the part of the string that comes before the last space
    return Y.substring(0, lastSpace);
}