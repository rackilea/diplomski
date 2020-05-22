Page<Show> findAllFiltered(@Param("eventId") Long eventId,
                           @Param("dateSearch") LocalDateTime dateSearch,
                           Pageable page) {
    LocalDateTime startDate = dateSearch.truncatedTo(ChronoUnit.DAYS);
    LocalDateTime endDate = startDate.plusDays(1);
    return findAllFiltered(eventId, startDate, endDate, page);
}