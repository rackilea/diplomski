Flux<Menu> allMenuFlux = Flux.empty();
Flux<Foodtruck> foodtruckFlux = foodtruckService.getAllFoodtrucks();

foodtruckFlux.toStream().forEach(foodtruck -> {
    Flux<Menu> currentMenuFlux = Flux.fromIterable(foodtruck.getMenus());
    allMenuFlux.mergeWith(currentMenuFlux);
});