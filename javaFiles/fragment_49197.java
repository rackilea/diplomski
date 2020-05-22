Expression<String> replacedValue = criteriaBuilder.function("replace", 
            String.class, root.get("version"), criteriaBuilder.literal("."), 
            criteriaBuilder.literal(""));

    Expression<String> lpadValue = criteriaBuilder.function("lpad", 
            String.class, replacedValue, criteriaBuilder.literal(20),
            criteriaBuilder.literal("0"));

    criteriaQuery.orderBy(criteriaBuilder.desc(lpadValue));