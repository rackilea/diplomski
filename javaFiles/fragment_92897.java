onlinePostalcodes = onlinePostalcodes
            .stream()
            .filter(e -> e.getPostalcode() != null)
            .collect(Collectors.toSet());

    onlinePostalcodes.removeAll(offlinePostalcodes);