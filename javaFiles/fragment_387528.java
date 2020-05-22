for (char s : string.toCharArray()) {
        switch (state) {
        case (1): {
            if (s == 'e' || s == 'l' || s == 'o' || s == 'x') {
                state = 1;
            } else if (s == 'g') {
                state = 2;
            }
            break;
        }

        case (2): {
            if (s == 'e' || s == 'l' || s == 'x') {
                state = 1;
            } else if (s == 'o') {
                state = 2;
            } else if (s == 'g') {
                state = 3;
            }

            break;
        }

        case (3): {
            if (s == 'e' || s == 'x') {
                state = 1;
            } else if (s == 'g' || s == 'o') {
                state = 2;
            } else if (s == 'l') {
                state = 4;
            }

            break;
        }
        case (4): {
            if (s == 'g' || s == 'l' || s == 'o' || s == 'x') {
                state = 1;
            } else if (s == 'e') {
                state = 5;
            }
            break;
        }
        case (5): {
            if (s == 'e' || s == 'g' || s == 'l' || s == 'o' || s == 'x') {
                state = 5;
            } else {
                state = 5;
            }
            break;
        }

        }
    }