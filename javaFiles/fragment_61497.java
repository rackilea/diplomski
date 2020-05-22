String s = "אבגדהאבגדהصضطظع"; // First Hebrew, then Arabic.
    int i0 = 0;
    for (int i = 0; i < s.length(); ) {
        int codePoint = s.codePointAt(i);
        i += Character.charCount(codePoint);
        boolean rtl = Character.getDirectionality(codePoint)
                == Character.DIRECTIONALITY_RIGHT_TO_LEFT;
        boolean rtl2 = Character.getDirectionality(codePoint)
                == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
        System.out.printf("[%d - %d] '%s': LTR %s %s%n",
                i0, i, s.substring(i0,  i), rtl, rtl2);
        i0 = i;
    }

[0 - 1] 'א': LTR true false
[1 - 2] 'ב': LTR true false
[2 - 3] 'ג': LTR true false
[3 - 4] 'ד': LTR true false
[4 - 5] 'ה': LTR true false
[5 - 6] 'א': LTR true false
[6 - 7] 'ב': LTR true false
[7 - 8] 'ג': LTR true false
[8 - 9] 'ד': LTR true false
[9 - 10] 'ה': LTR true false
[10 - 11] 'ص': LTR false true
[11 - 12] 'ض': LTR false true
[12 - 13] 'ط': LTR false true
[13 - 14] 'ظ': LTR false true
[14 - 15] 'ع': LTR false true