for (i = 0; i < arrayList.length; i++) {
    int randChar = (int) (65 + Math.random() * (58));
    while (randChar >= 91 && randChar <= 96) {
        randChar = (int) (65 + Math.random() * (58));
    }
    arrayList[i] = (char) randChar;
    if (Character.isLowerCase(arrayList[i])) {lowercaseCount++;}
    if (Character.isUpperCase(arrayList[i])) {uppercaseCount++;}
}