@Module
class CarModule {

@Singleton
@Provides
public Car provideCar(Engine engine) {
    MarutiCar marutiCar = new MarutiCar(engine);
    }

@Singleton
@Provides
public Engine provideEngine(FordEngine fordEngine) {
    return fordEngine;
    }
}