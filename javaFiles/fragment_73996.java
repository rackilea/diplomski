@Query("select gm from GuestsMeeting gm inner join gm.group g 
where  
  (:startDate IS NULL or gm.created_at >= : startDate)  
and 
  (:endDate IS NULL or gm.created_at <= :endDate) 
and g.id = : groupId")
List<GuestsMeeting> findAll(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("groupId") long groupId);