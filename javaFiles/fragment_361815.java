EntityAbstract one = entityRepository.findOne(((Specification<EntityAbstract>)
        (root, query, builder) -> {
            Expression<?>[] expressions = {root.<String>get("content"), builder.literal("unit"), builder.literal("id")};
            return toPredicate(root, query, builder, projectionName, expressions);
        }
)).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));