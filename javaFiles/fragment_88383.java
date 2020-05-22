Character c = null;
        int strLength = line.length();

        for (int i = 0; i < strLength - 1;) {

            int flag = 0;
            int present_char_position = 0;

            if (line.charAt(i) == line.charAt(i + 1)) {
                flag++;
                present_char_position = i;
                i += 2;//jumping from those two character if matched
                continue;
            } else {
                present_char_position = i;
                i++;//if not matched go to next character
            }

            if (flag == 0) {
                c = line.charAt(present_char_position);
                break;
            }

        }
        return c;