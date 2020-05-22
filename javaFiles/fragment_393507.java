list.sort((o1, o2) -> {
        if (o1.getUserId() == o2.getUserId()) {
            return Integer.compare(o2.getValue(), o1.getValue());
        } else if(o1.getUserId() == 1000) {
            return -1;
        } else if (o2.getUserId() == 1000) {
            return 1;
        }
        return Integer.compare(o2.getValue(), o1.getValue());
    });