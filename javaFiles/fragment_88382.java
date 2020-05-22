Character c = null;
    int strLength = line.length();

    for (int i = 0; i < strLength; i++) {

        int flag = 0;
        for (int j = 0; j < strLength; j++) {
            if (line.charAt(i) == line.charAt(j) && i != j) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            c = line.charAt(i);
            break;
        }

    }
    return c;