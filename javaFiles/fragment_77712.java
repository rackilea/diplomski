for (Optional<Joined> value : map.values()) {
        value.ifPresent(joined -> System.out.println(joined.getPriceName() + " " + joined.getPrice()));
    }

// O1 250
// F1 100