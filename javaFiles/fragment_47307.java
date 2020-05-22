double calcStddev(ArrayList<Double> angles){
      double sin = 0;
      double cos = 0;
      for(int i = 0; i < angles.size(); i++){
           sin += Math.sin(angles.get(i) * (Math.PI/180.0));
           cos += Math.cos(angles.get(i) * (Math.PI/180.0)); 
      }
      sin /= angles.size();
      cos /= angles.size();

      double stddev = Math.sqrt(-Math.log(sin*sin+cos*cos));

      return stddev;
 }