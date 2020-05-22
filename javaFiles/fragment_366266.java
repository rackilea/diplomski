String value = iterator.next();
JavaRDD<String> numAs = positiveComments.filter(new Function<String, Boolean>()
      {
        public Boolean call(String s)
        {
          return s.contains(value);
        }
      });