import static java.util.stream.Collectors.*;

List<Patient> patients = ... ;

Map<Department, Long> frequency =
    patients.stream()
        .flatMap(p -> p.getHistory().stream())
        .collect(groupingBy(d -> d, counting()));