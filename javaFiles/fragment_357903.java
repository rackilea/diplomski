public Iterable<SubEntity> getSubEntities() {
    return Iterables.transform(samples, new Function<EntityThree, SubEntity>() {
        @Override
        public SubEntity apply(EntityThree input) {
            return input.getSubEntity();
        }
    });
}