for (Entry<String, List<String>> entry : map.entrySet())
      {
          System.out.println(entry.getKey() + ":");
          for (String s : entry.getValue()){
              System.out.println(s);
          }
      }