public void countryList() {

        for (int i = 0; i < list.size(); i++) {

            DataHolder item = new DataHolder();
            item.setName(i + "name");
            item.setTranslation(i + "translation");

            list.add(item);
        }
    }