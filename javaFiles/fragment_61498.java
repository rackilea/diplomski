int arabic(String s) {
    int n = 0;
    for (char ch : s.toCharArray()) {
        if (Character.getDirectionality(codePoint)
                == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC) {
            ++n;
            if (n > 1000) {
                break;
            }
        }
    }
    return n;
}
int hebrew(String s) {
    int n = 0;
    for (char ch : s.toCharArray()) {
        if (Character.getDirectionality(codePoint)
                == Character.DIRECTIONALITY_RIGHT_TO_LEFT) {
            ++n;
            if (n > 1000) {
                break;
            }
        }
    }
    return n;
}

if (arabic(s) > 0) {
    return "Windows-1256";
} else if (hebrew(s) > 0) {
    return "Windows-1255";
} else {
    return "Klingon-1257";
}