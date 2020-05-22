public Page<Accommodation> findAccommodationsByFilter(AccommodationFilter filter, Pageable pageable) {

    Criteria listedTrue = where("listed").is(true);
    Query query = query(listedTrue);
    filter.pricePerNight().map(where("pricePerNight")::lte).ifPresent(query::addCriteria);
    filter.guests().map(where("guests")::gte).ifPresent(query::addCriteria);
    filter.type().map(where("type")::is).ifPresent(query::addCriteria);
    filter.rating().map(where("rating")::gte).ifPresent(query::addCriteria);
    filter.trustedLandlord().map(where("landlord.trusted")::is).ifPresent(query::addCriteria);
    filter.country().map(where("address.country")::is).ifPresent(query::addCriteria);
    filter.city().map(where("address.city")::is).ifPresent(query::addCriteria);

    if(filter.checkout().isPresent() && filter.checkin().isPresent()){
        Criteria c = where("bookings")
                .not()
                .elemMatch(where("checkin").lte(filter.checkout().get())
                        .and("checkout").gte(filter.checkin().get()));

        query.addCriteria(c);
    }

    long total = this.mongoOperations.count(query, Accommodation.class);

    query.with(pageable);
    List<Accommodation> accommodations = this.mongoOperations.find(query, Accommodation.class);

    return new PageImpl<>(accommodations, pageable, total);
}