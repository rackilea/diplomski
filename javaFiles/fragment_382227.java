private static final Pattern splitPattern = Pattern.compile("\\d+");

    @Override
    public int compare(String str1, String str2) {
        Iterator<String> i1 = splitStringPreserveDelimiter(str1).iterator();
        Iterator<String> i2 = splitStringPreserveDelimiter(str2).iterator();
        while (true) {
            // Til here all is equal.
            if (!i1.hasNext() && !i2.hasNext()) {
                return 0;
            }
            // first has no more parts -> comes first
            if (!i1.hasNext() && i2.hasNext()) {
                return -1;
            }
            // first has more parts than i2 -> comes after
            if (i1.hasNext() && !i2.hasNext()) {
                return 1;
            }

            String data1 = i1.next();
            String data2 = i2.next();
            int result;

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                result = sdf.parse(data1).compareTo(sdf.parse(data2));
                if (result != 0) {
                    return result;
                }
            } catch (final ParseException e) {
                /* continue */
            }

            try {
                // If both datas are numbers, then compare numbers
                result = Long.compare(Long.valueOf(data2),
                        Long.valueOf(data1));
                // If numbers are equal than longer comes first
                if (result == 0) {
                    result = -Integer.compare(data1.length(),
                            data2.length());
                }
            } catch (NumberFormatException ex) {
                // compare text case insensitive
                result = data1.compareToIgnoreCase(data2);
            }

            if (result != 0) {
                return result;
            }

        }
    }