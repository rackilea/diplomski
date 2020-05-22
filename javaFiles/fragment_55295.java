// First, group the lists by the "id" i.e. the first entry in each list
final Map<String, List<List<String>>> groupedLists =
        Stream.of(archiveList1, archiveList2, archiveList3, archiveList4)
                .collect(Collectors.groupingBy(l -> l.get(0)));

// Now, setup the result
final List<List<String>> result = groupedLists.values()
        .stream()
        .map(ll -> {
            String first = ll.get(0).get(0);        // The key e.g. "2605"
            String second = ll.get(0).get(1);       // The second element e.g. "SD"

            // Summarize the lists with the same "id"
            int sum = ll.stream()
                    .map(archive -> archive.get(2)) // This is the "number"
                    .mapToInt(Integer::parseInt)    // convert it to an int
                    .sum();                         // And summarize

            // This list holds the aggregated result
            List<String> aggregate = new ArrayList<>();
            aggregate.add(first);
            aggregate.add(second);
            aggregate.add(Integer.valueOf(sum).toString());
            return aggregate;
        })
        .collect(Collectors.toList());              // Finally, collect the whole thing to a list of lists