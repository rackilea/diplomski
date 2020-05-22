private static Collection<MyObject> aggregate(List<MyObject> objects) {
        Map<String, MyObject> map = new HashMap<String, MyObject>();

        for (MyObject current : objects) {
         String key = String.format("%s:%s", current.gender, current.state);
           MyObject aggregated = map.get(key);
          if (aggregated == null) {
                aggregated = new MyObject();
               aggregated.setGender(current.getGender());
               aggregated.setState(current.state);
               map.put(key, aggregated);
          }
          aggregated.nombre+=1;
           aggregated.setQuantity(aggregated.getQuantity() + current.getQuantity());
            aggregated.setSalary((aggregated.getSalary() + current.getSalary()));

         }
            for(MyObject c : map.values()){
            c.setSalary(c.getSalary()/c.nombre);

        }

        return map.values();
    }