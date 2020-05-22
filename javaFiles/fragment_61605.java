@Query(value = "SELECT *" +
                " FROM show s" +
               " WHERE s.event_id = :eventId" +
                 " AND s.start >= :startDate" +
                 " AND s.start < :endDate", nativeQuery = true)
Page<Show> findAllFiltered(@Param("eventId") Long eventId,
                           @Param("startDate") LocalDateTime startDate,
                           @Param("endDate") LocalDateTime endDate,
                           Pageable page);