Collections.sort(jList, new Comparator<GetJournalsModel>() {
        @Override
        public int compare(GetJournalsModel a1, GetJournalsModel a2) {
            return a1.getFre() - a2.getFre();
        }
    });