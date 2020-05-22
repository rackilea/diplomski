public static void main(String[] args) throws ParseException {
        String input = "2014/12/31";
        boolean checkformat;
        if (input.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})")) // for yyyy/MM/dd format
            checkformat = true;
        else
            checkformat = false;

        System.out.println(checkformat);
    }