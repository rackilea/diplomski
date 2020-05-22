query.where(
    builder.or(
        builder.like(
            builder.lower(
                root.get(
                    type.getDeclaredSingularAttribute("username", String.class)
                )
            ), "%" + keyword.toLowerCase() + "%"
        ), 
        builder.like(
            builder.lower(
                root.get(
                    type.getDeclaredSingularAttribute("firstname", String.class)
                )
            ), "%" + keyword.toLowerCase() + "%"
        ), 
        builder.like(
            builder.lower(
                root.get(
                    type.getDeclaredSingularAttribute("lastname", String.class)
                )
            ), "%" + keyword.toLowerCase() + "%"
        )
    )
);