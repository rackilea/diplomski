public class Vehicle {
    private int year;
    private String model;
    private String category;

    //other 
}


Map<Integer,Map<String,List<String>>> result =  vehicles.stream()
            .collect(Collectors.groupingBy(Vehicle::getYear,
                    Collectors.groupingBy(Vehicle::getCategory, 
                            Collectors.mapping(Vehicle::getModel, Collectors.toList()))));