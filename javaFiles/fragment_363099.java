mapLstInteger.values()
             .stream()
             .collect(Collector.of(
                     () -> new ArrayList<>(),  // Supplier
                     (output, toSumList) -> {  // Accumulator
                         output.add(toSumList.stream()
                                             .mapToInt(Integer::intValue)
                                             .sum());
                     },
                     // The Combiner implementation will be called
                     // in case of a "parallel" Stream. 
                     // No need to worry about it here. 
                     // But in case, we would need to merge the partial results
                     (output, partial) -> {
                        output.addAll(partial);
                        return output;
                     }
             ));