Api.getCars()
    .flatMap(cars -> Observable.from(cars)) // flatten your list
    .flatmap(car -> Api.getOwner(car), // request each owner
            (car, owner) -> {
                car.setOwner(owner); // assign owner to the car
                return Observable.just(car);
            })
    .toList() // collect items into List
    ... // here is your Observable<List<Car>>