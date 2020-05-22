QEvent event = QEvent.event;
QOrganization organization = QOrganization.organization;
query.from(event)
    .innerJoin(event.organization, organization)
    .where(organization.country.in("India", "USA"))
    .list(event);