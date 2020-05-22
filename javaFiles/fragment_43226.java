Collections.sort(list, new Comparator<Currency>() {
        @Override
        public int compare(Currency c1, Currency c2) {
            return c1.getCurrencyName().compareToIgnoreCase(c2.getCurrencyName());
        }
    })