Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String key1, String key2) {
          int returned = sequence.indexOf(key1) - sequence.indexOf(key2);

          if (returned == 0 && !key1.equals(key2))
              returned = -1;

          return returned;

      }
  };