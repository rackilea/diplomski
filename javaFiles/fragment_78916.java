@Autowired
public SmallCar(@Qualifier("brandA") CarEngine carEngine) {
    this.carEngine = carEngine;
}

@Autowired
public Bus(@Qualifier("brandB") CarEngine carEngine) {
    this.carEngine = carEngine;
}