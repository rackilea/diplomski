final String[] acceptLtrs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {

             if (source.toString().isEmpty()) return null;
                for (String acceptLtr : acceptLtrs) {
                    if (source.equals(acceptLtr)) {
                        return null; // will accept input
                    }
                }

             return ""; // will dismiss the input or you can show error here

}};