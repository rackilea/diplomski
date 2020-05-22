if (linearray[2].length() == 16) {
        String first8 = linearray[2].substring(0, 7);
        String last8 = linearray[2].substring(8, 15);
        String value = "-default";      
        try {
            int isNum = Integer.parseInt(first8);
            if (isNum > 0) {
                if (last8.endsWith(value)) {
                    return "Correct";
                } else {
                    return "Incorrect";
                }
            } else {
                return "Incorrect";
            }
        } catch (NumberFormatException e) {
            return "Incorrect";
        }
    }