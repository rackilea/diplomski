TextField textField = new TextField(){
        public boolean validChar(String c) {
            if (((c.charAt(0) > 'a') && (c.charAt(0) < 'z')) || ((c.charAt(0) > 'A') && (c.charAt(0) < 'Z'))) {
                return true;
            }
            return false;
        }
    };