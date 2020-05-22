StringBuilder sb = new StringBuilder();
    try (BufferedInputStream is = new BufferedInputStream(new FileInputStream("1.txt"))) {
        for (int b; (b = is.read()) != -1;) {
            String s = Integer.toHexString(b).toUpperCase();
            if (s.length() == 1) {
                sb.append('0');
            }
            sb.append(s).append(' ');
        }
    }
    System.out.println(sb);