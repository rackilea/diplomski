import static java.util.stream.Collectors.*;

Map<Farm, Optional<Employee>> collect = 
        farmList.stream().collect(groupingBy(Function.identity(),
            flatMapping(farm -> farm.getEmployes().stream(), 
                   maxBy(Employee::compareTo))));