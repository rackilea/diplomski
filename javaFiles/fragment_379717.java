repository.findAll(where(withCity(city))
    .and(withBrand(brand))
    .and(withModel(model))
    .and(withVehicleType(type))
    .and(withYear(year))
    .and(withState(state)));