@Query( nativeQuery = true, value = "select domain_name.* from domain_name, domain_name_reminder, reseller " +
        "where domain_name.reminder_id = domain_name_reminder.id " +
        "and domain_name_reminder.second_notification=current_date - interval ':totalDays days' " +
        "and reseller.myCheck=true " +
        "and reseller.id = domain_name.invoicing_party_id ")
public List<DomainName> findDomainsBySecondNotificationDate(@Param("totalDays")Integer totalDays);