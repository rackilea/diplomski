DocumentFilter df = new DocumentFilter() {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {

            if (isDigit(string)) {
                super.insertString(fb, i, string, as);
                calcAndSetTotal();
            }
        }
         @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
            calcAndSetTotal();
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            if (isDigit(string)) {
                super.replace(fb, i, i1, string, as);
                calcAndSetTotal();

            }
        }

        private boolean isDigit(String string) {
            for (int n = 0; n < string.length(); n++) {
                char c = string.charAt(n);//get a single character of the string
                //System.out.println(c);
                if (!Character.isDigit(c)) {//if its an alphabetic character or white space
                    return false;
                }
            }
            return true;
        }

        void calcAndSetTotal() {
            int sum = 0;
            int fr = 0;
            int pc = 0;
            int tax = 0;
            int total = 0;

            if (!Fare.getText().isEmpty()) {
                fr= Integer.parseInt(Fare.getText());//we must add this
            }
            if (!Tax.getText().isEmpty()) {
                tax= Integer.parseInt(Tax.getText());//we must add this
            }
            if (!commper.getText().isEmpty()) {
                pc= Integer.parseInt(commper.getText());//we must subtract this
            }
            sum =(int) (fr *(pc*0.01));

            total = (int) (fr + tax - sum);
            comm.setText(String.valueOf(sum));
            CostPrice.setText(String.valueOf(total));
        }
    };