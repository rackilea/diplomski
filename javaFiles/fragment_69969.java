System.out.println(
        String.format("%2s", Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH)).replace(" ", "0") +
        "-" +
        String.format("%2s", (Calendar.getInstance().get(Calendar.MONTH) + 1)).replace(" ", "0") +
        "-" +
        Calendar.getInstance().get(Calendar.YEAR) +
        " - " +
        String.format("%2s", Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)).replace(" ", "0") +
        "-" +
        String.format("%2s", (Calendar.getInstance().get(Calendar.MONTH) + 1)).replace(" ", "0") +
        "-" +
        Calendar.getInstance().get(Calendar.YEAR));