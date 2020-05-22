@Module
class CarModule {

@Singleton
@Provides
public Car provideCar(MarutiCar marutiCar) {
    return marutiCar;
    }

@Singleton
@Provides
public Engine provideEngine(FordEngine fordEngine) {
    return fordEngine;
    }
}