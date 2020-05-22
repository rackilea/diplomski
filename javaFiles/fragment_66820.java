Predicate<String> filter = new Predicate<String>() {
        @Override
        public boolean apply(String input) {
            return input.startsWith("src") || input.startsWith("assoc") || input.startsWith("dest");
        }
    };

    Function<String, Integer> assignWeights = new Function<String, Integer>() {
        @Override
        public Integer apply(String from) {
            if (from.startsWith("src")) {
                return 0;
            } else if (from.startsWith("assoc")) {
                return 1;
            } else if (from.startsWith("dest")) {
                return 2;
            } else {
                /* Shouldn't be possible but have to do something */
                throw new IllegalArgrumentException(from + " is not a valid argument");
            }
        }
    };

    ImmutableList<String> sortedFiltered = ImmutableList.copyOf(
            Ordering.natural().onResultOf(assignWeights).sortedCopy(
                    Iterables.filter(testList, filter)
            )
    );