public class Info {
      public static Info info;
      private ArrayList<Object> list;

      public static Info getInstance(){
        if(info == null)
           info = new Info();
        return info;
      }    

      private Info(){
        this.list = new ArrayList<>();
      }

      public void put(final byte[] macAddress, final String name) {
        HashMap<byte[], String> map = new HashMap<>();
        map.put(macAddress,name);

        list.add(map);
      }

      public ArrayList getList(){
        return list;
      }
    }