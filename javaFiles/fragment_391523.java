public class CalculateImpl implements Calculate { 
     @Override
     public List<Double> calculate(List<Double> priceList, Predicate<Double> filter) { 
         priceList.stream().filter(filter).collect(Collectors.toList());
    } 
}