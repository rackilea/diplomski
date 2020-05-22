class ServletCar extends HttpServlet {
   private CarService carService;
   public void doPost( ... )
  {
   ...
   switch (action) {
       ...
       case 'insert':
           carService.insert(carParam)
           break;
       ...
   }
   ... 
  }
}

public interface CarService {
    save(Car car);
    update(Car car);
    delete(Car car);
}

public class CarServiceImpl implements CarService {

    save (Car car) {
     ...
    }

}