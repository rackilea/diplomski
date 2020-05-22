HashMap<String,Car> vehicle = new HashMap<>();
Details def= new Details();
Car car = new Car();
car.name = "Mustang";
def.model = "SportsRoof";
def.model_no = 1969;
def.color = "Blue";
car.features.add(def);
vehicle.put("Ford",car);
// create a new Car object
car = new Car();
car.name = "R8";
def.model = "Coupe";
def.model_no = 2009;
def.color = "Black";
car.features.clear();
car.features.add(def);
vehicle.put("Audi",car);