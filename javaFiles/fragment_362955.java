Collector<Widget, ?, TreeSet<Widget>> intoSet =
     Collector.of(
         TreeSet::new, 
         TreeSet::add,
         (left, right) -> { left.addAll(right); return left; }
     );