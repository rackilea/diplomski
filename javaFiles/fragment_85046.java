// Repository
@Query(value="{name: ?0, approval: {'$ne': null}}",
        sort="{'approval.approvedDate': -1}",
        fields = "{ _id: 1 }")
Stream<Item> getLatestApprovedIdByName(String name);

// Service
default Item getLatestApprovedIdByName(String name) {
    return getLatestApprovedIdByName(name).stream().findFirst().orElse(null);
}