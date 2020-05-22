public Person list2Person(List<FIELDS> fields) {
       Builder builder = new Person.builder();
       for (Field field : fields) {
           switch (field) {
           case FIRST:
              builder.first(getValue(FIRST));
              break;
           case MIDDLE:
              builder.middle(getValue(MIDDLE));
              break;
           ...
           }
           return builder.build();
       }
   }