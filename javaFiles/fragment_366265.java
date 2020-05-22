JavaRDD<String> numAs = positiveComments.filter(new Function<String, Boolean>()
      {
        private Iterator<...> $iterator;
        public Boolean call(String s)
        {
          return s.contains($iterator.next());
        }
      });