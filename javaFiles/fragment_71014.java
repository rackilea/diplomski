SimpleDateFormat msSDF = new SimpleDateFormat("SSS") {

            @Override
            public Date parse(String source) throws ParseException {
                return new Date(Long.parseLong(source));
            }

};