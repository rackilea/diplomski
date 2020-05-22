import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;


Map<Route,Integer> routeCounts = routes.stream()
        .collect(groupingBy(x -> x))
        .values().stream()
        .collect(toMap(
            lst -> lst.stream().max(comparingLong(Route::getLastUpdated)).get(),
            List::size
        ));