import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Main {
    static Map<String, Map<String, Map<String, Set<Integer>>>> parse(List<Version> input) {
        return input.stream()
            .flatMap(version -> version.jobs.stream().map(job -> new Entry(version, job)))
            .collect(
                groupingBy(
                    entry -> entry.jobName,
                    groupingBy(
                        entry -> entry.serverName,
                        groupingBy(
                            entry -> entry.jobVersion,
                            mapping(entry -> entry.serverNumber, toSet())
                        )
                    )
                )
            );
    }
}