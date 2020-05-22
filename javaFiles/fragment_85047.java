// Repository
@Query(value = "{name: ?0, approval: {'$ne': null}}", fields = "{ _id: 1 }")
Page<Item> getLatestApprovedIdByName(String name, Pageable pageable);

// Service
default Item getLatestApprovedIdByName(String name) {
    PageRequest request = new PageRequest(0, 1, new Sort(Sort.Direction.DESC, "approval.approvedDate"));
    return getLatestApprovedIdByName(name, request).getContent().get(0);
}