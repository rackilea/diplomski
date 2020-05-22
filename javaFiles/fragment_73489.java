protected Map<String, ArrayList<ArrayList<Double>>> history = new HashMap<String,ArrayList<ArrayList<Double>>>();
    Double time=null;
    Double value=null;
    time2=null;
    ArrayList <Double> inner=null;
    for (String act:keySet){
      ArrayList<ArrayList<Double>> outer=null;
      if ((outer=history.get(act))==null)
      {
         outer= new ArrayList<ArrayList<Double>> ();
      }
       inner=new ArrayList <Double>();
       time= value1;//your value for this integer 
       value= value2;
       inner.add(time);
       inner.add(value);
       outer.add(inner);

       history.put(act, outer);
       }