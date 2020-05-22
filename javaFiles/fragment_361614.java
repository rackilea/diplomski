Set<Long> memberIds = 
    marksDistribution.parallelStream()
                     .collect(HashSet::new, 
                              (s, m) -> {
                                   s.add(m.getStudentId());
                                   s.add(m.getTeacherId());
                               }, Set::addAll);