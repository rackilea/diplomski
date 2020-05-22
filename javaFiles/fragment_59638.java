Collections.sort(sortedData, new Comparator<ElementToSort>() {
        @Override
        public int compare(ElementToSort voy1, ElementToSort voy2) {
            return ComparisonChain.start()
                .compare(minDates.get(voy1.getPio()), minDates.get(voy2.getPio()))
                .compare(voy1.getPio(), voy2.getPio())
                .compare(voy1.getDate(), voy2.getDate())
                .result();
        }
    });