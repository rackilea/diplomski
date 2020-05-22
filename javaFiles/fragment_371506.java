private enum MatchType {
        PIT("PIT",                 1, false, false),
        PREDICTIONS("PREDICTIONS", 2, false, false),
        MATCH("Match",             3, true,  false),
        QUARTERS("Quarters",       4, true,  true),
        SEMIS("Semis",             5, true,  true),
        FINALS("Finals",           6, true,  false)
        ;

        private String name;
        private int matchTypeOrder;
        private boolean hasMatchOrder;
        private boolean hasSubmatches;

        MatchType(String name, int matchTypeOrder, boolean hasMatchOrder, boolean hasSubmatches) {
            this.name           = name;
            this.matchTypeOrder = matchTypeOrder;
            this.hasMatchOrder  = hasMatchOrder;
            this.hasSubmatches  = hasSubmatches;
        }

        public boolean hasMatchOrder() {
            return hasMatchOrder;
        }

        public boolean hasSubmatches() {
            return hasSubmatches;
        }

        public static MatchType getByName(String matchName) {
            for (MatchType value : values()) {
                if (value.getName().equalsIgnoreCase(matchName))
                    return value;
            }
            return null;
        }

        private String getName() {          
            return name;
        }

        public int getMatchTypeOrder() {            
            return matchTypeOrder;
        }
    }