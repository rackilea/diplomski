public static String fancyPrint(Object... array) {
        StringBuilder output = new StringBuilder();
        int total = 0;
        for (Object o : array) {
            output.append(o.toString());
            total+=1;
            if (total%3==0) {
                output.append(" ---> ");
            } else {
                output.append(", ");
            }
        }
        //remove last ", " or " ---> " printed
        if (total%3==0) {
            output.delete(output.length()-" ---> ".length(), output.length());
        } else {
            output.delete(output.length()-", ".length(), output.length());
        }
        return output.toString();
    }