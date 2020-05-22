@Query("select e from Entity e where "
      +"(:country = '' or e.country like '%:country%') and "
      +"(:state = '' or e.state like '%:state%') and "
      +"(:district = '' or e.district like '%:district%') and "
      +"(:zipCode = '' or e.zipCode like '%:zipCode%')"
Page<Entity> advancedSearch(@Param("country") String country,
                            @Param("state") String state,
                            @Param("district") String district,
                            @Param("zipCode") String zipCode,
                            Pageable page);