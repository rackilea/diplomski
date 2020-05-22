Map<String,List<String>> mp=new HashMap<String,List<String>>();
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the instrument name");
      String name=sc.next();
      List<String> valList = new ArrayList<String>();
      valList.add("Control Valve");
      valList.add("BDV");
      valList.add("SDV");
      valList.add("ON-OFF VALVE");
      valList.add("Analyser");
      mp.put(name,valList);

      for(String key : mp.keySet()){
          System.out.print("Instrument name :"+key+" Values : ");
          for(String val : mp.get(key)){
              System.out.print(val+",");
          }


      }