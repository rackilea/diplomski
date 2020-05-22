@Override
        public Object stringToValue(String text) throws ParseException {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateFormatter.parse(text));
            return cal;
        }