@Modifying
@Query("UPDATE User u SET active = false WHERE u.id IN :ids")
void deactivateAll(@Param("ids") Long... ids);

@Modifying
@Query("UPDATE User u SET active = false WHERE u.id IN :ids")
void deactivateAll(@Param("ids") Iterable<Long> ids);