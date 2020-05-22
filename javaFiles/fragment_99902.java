Optional<Specification<DriverDO>> reduce = queryParams.keySet().stream().map(k -> {
        if (k.toLowerCase().contains("username")){
            return getDriversByUsername(queryParams.get(k));
        } else if (k.toLowerCase().contains("rating")){
            return  getDriversByCarRating(queryParams.get(k));
        }
        // ...
    }).reduce((a, b) -> a.and(b));