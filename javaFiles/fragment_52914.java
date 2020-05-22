@Query("select a,b.bedType,b.roomCategory from RoomDetail a left outer 
join RoomMaster b on a.roomId = b.id where lower(b.bedType.bedTypeName) like 
%:bedTypeName%")
<Page>RoomDetail findByBedType(
    @Param("bedTypeName") String bedTypeName,
    Pageable paging);