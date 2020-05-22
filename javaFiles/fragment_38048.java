for (char ch : user.toCharArray()) {
    if (Character.isLowerCase(ch)) {
        lLetter++;
    } else if (Character.isUpperCase(ch)) {
        uLetter++;
    }
}