public static void main(String[]args){
        Vector v = new Vector();
        v.addElement("RED");
        v.addElement("BLUE");
        v.addElement("GREEN");
        Vector v2 = new Vector();
        Vector v3 = null;
        v2.addElement("CSK");
        v2.addElement("RCB");
        v2.addElement("MI");
        for(int i=0; i<v.size(); i++){
            for(int j=0; j<v2.size(); j++){
                v3 = new Vector();
                v3.add(v.get(i));
                v3.add(v2.get(j));
                System.out.println(v3);
            }
        }
//      for(int i=0; i<v3.size(); i++){
//          System.out.println(v3);
//      }