Collections.sort(a, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {

            int minSize = Math.min(o1.length(), o2.length());
            int index = 0;

            while (index < minSize) {

                char c1 = o1.charAt(index);
                char c2 = o2.charAt(index);

                if (c1 != c2) {

                    if (o1.length() == o2.length()) {
                        return c1 - c2;
                    }

                    if (c1 == '!') {
                        return -1;
                    } else if (c2 == '!') {
                        return 1;
                    }

                    return o1.length() - o2.length();
                }

                index++;
            }

            if (o1.length() == index) {
                if (o2.length() == index) {
                    return 0;
                }

                return -1;
            } else {
                return 1;
            }
        }
    });