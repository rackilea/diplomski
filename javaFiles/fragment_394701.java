// for display purposes, we like the arguments in argument order, but the options in    alphabetical order
     Collections.sort(options, new Comparator<OptionHandler>() {
        public int compare(OptionHandler o1, OptionHandler o2) {
            return o1.option.toString().compareTo(o2.option.toString());
        } 
    });