import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
...

Map<String, Integer> map = 
    report.getQueries()
          .stream()
          .filter(q -> q.getComparisonFilter().isPresent())
          .filter(q -> q.getComparisonFilter().get().equals(view.getFilter().get()))
          .collect(groupingBy(q -> q.filterChoice.get(), summingInt(q -> q.queryOutput)));