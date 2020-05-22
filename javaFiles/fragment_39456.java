class SbS {
        StringBuilder sb = new StringBuilder();
        String s = "";

        @Override
        public String toString() {
            return sb + (s.empty() ? "" : " and " + s);
        }
    }
    result = ls.stream()
            .collect(SbS::new,
                (a, s) -> {
                    a.sb.append(a.sb.length() == 0 ? "" : ", ").append(a.s); a.s = s;
                },
                (a1, a2) -> {}).toString();