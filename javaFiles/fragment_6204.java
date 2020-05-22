ObservableList<Person> items = table.getItems();

        // initialize counts (only needed once, and only if items is non-empty):
        int vip = 0 ;
        int total = table.getItems().size();
        for (Person item : items) {
            if (Person.Status.VIP.equals(item.getStatus())) vip++ ;
            if (Person.Status.NONVIP.equals(item.getStatus())) nonvip++ ;
        }

        IntegerProperty vipCount = new SimpleIntegerProperty(vip);
        IntegerProperty totalCount = new SimpleIntegerProperty(total);

        totalvip.textProperty().bind(vipCount.asString("VIP: %s"));
        totalperson.textProperty().bind(totalCount.asString("Total persons: %s"));

        items.addListener((
                ListChangeListener.Change<? extends Person> c) -> {
            while (c.next()) {

                if (c.wasAdded()) {
                    for (Person item : c.getAddedSubList()) {
                        totalCount.set(totalCount.get() + 1);
                        if (Person.Status.VIP.equals(item.getStatus())) vipCount.set(vipCount.get() + 1) ;
                    }
                }

                if (c.wasRemoved()) {
                    for (Person item : c.getRemoved()) {
                        totalCount.set(totalCount.get() - 1);
                        item.statusProperty().removeListener(listener);
                        if (Person.Status.VIP.equals(item.getStatus())) vipCount.set(vipCount.get() - 1) ;
                        if(vipCount.get() < 0 ) vipCount.set(0); //prevent negative
                    }
                }

            }
        });