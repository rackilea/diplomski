new ParseQuery<Whatever>("WHATEVER")
    .findInBackground(new FindCallback<Whatever>() {
        @Override
        public void done(List<Whatever> list, ParseException e) {
            // check for ParseException
            Integer sum = 0;
            for (final Whatever whatever : list) {
                sum += (Integer) whatever.get("Debt");
            }
            // there is your SUM
        }
});