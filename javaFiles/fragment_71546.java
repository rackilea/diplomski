@Query("select c.id " +
  "from Parent p " +
  "inner join p.children c " +
  "where p = :parent and " +
  "c.childrenName like concat(:childrenName,'%')")
Page<Long> findIdsBy(@Param("parent") Parent parent,
  @Param("childrenName") String childrenName,
  Pageable pageable);

@Query("from Children c join fetch c.grandChildren where c.id in :ids")
List<Children> getChildrenByIdWithGrandChildren(@Param("ids") List<Long> ids);