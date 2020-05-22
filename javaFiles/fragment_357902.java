public List<SubEntity> getSubEntities() {
    List<SubEntity> result = Lists.newArrayListWithExpectedSize(samples.size());
    for (EntityThree sample : samples) {
        result.add(sample.getSubEntity());
    }
    return result;
}