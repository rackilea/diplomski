private enum Column {

        COL1("col1"), COL2("col2");

        private String name;

        public String getName() {
            return name;
        }

        Column(final String name) {
            this.name = name;
        }

}