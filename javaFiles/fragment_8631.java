Specifications.where(
    (root, query, builder) -> {
        final Join<PersonEntity, AddressEntity> addresses = root.join(PersonEntity_.address, JoinType.LEFT);
        return builder.or(
            builder.like(builder.lower(addresses.get(AddressEntity_.addressLine1)), text),
            builder.like(builder.lower(addresses.get(AddressEntity_.addressLine2)), text),
            builder.like(builder.lower(addresses.get(AddressEntity_.code)), text),
        );
    }
);