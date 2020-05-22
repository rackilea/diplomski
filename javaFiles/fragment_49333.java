if (text.length() != 0) {
                predicatesAnd.add(builder.or(
                        builder.like(
                        builder.lower(
                        root.get(
                        type.getDeclaredSingularAttribute("description", String.class))), "%" + text.toLowerCase() + "%"),
                        builder.like(
                        builder.lower(
                        root.get(
                        type.getDeclaredSingularAttribute("summary", String.class))), "%" + text.toLowerCase() + "%"),
                        builder.like(
                        builder.lower(
                        tupdates.get(
                        typeTU.getDeclaredSingularAttribute("description", String.class))), "%"+text.toLowerCase()+"%")
                        ));
            }

    query.orderBy(builder.desc(root.get("startdate")));
    query.distinct(true);