public String drawDigitsFromString(String strValue){
            String str = strValue.trim();
            String digits="";
            for (int i = 0; i < str.length(); i++) {
                char chrs = str.charAt(i);              
                if (Character.isDigit(chrs))
                    digits = digits+chrs;
            }
            return digits;
        }