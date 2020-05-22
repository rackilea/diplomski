public String toString() {
        String description = matchType.getName();
        if (matchType.hasMatchOrder()) {
            description +=  " " + matchOrder;

            if (matchType.hasSubmatches()) 
                description +=  " Match " + subMatchOrder;
        }

        return description;
    }