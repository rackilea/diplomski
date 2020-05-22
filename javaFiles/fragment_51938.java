String s = "rn -r\b\b\b\b -r[K\b\b\bm -r\b\b\b";
    StringBuilder sb = new StringBuilder();
    int cursor = 0;
    for (char c : s.toCharArray()) {
        if (c == '\b') {
            if (cursor > 0) {
                sb.deleteCharAt(--cursor);
            }
        } else if (c == 37) {   // left arrow
            if (cursor > 0) {
                cursor--;
            }
        } else if (c == 39) {   // right arrow
            if (cursor < sb.length()) {
                cursor++;
            }
        } else if (!Character.isISOControl(c)) {
            sb.insert(cursor++, c);
        }
    }
    System.out.println(sb);