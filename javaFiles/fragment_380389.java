String carId = "...";
Car car = ...;

CarServiceImpl car = mock(CarServiceImpl.class);
when(car.findById(carId)).thenReturn(car);    
when(car.deleteById(carId)).thenCallRealMethod();