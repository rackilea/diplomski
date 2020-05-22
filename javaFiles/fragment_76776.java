for(String x : ol) {
     System.out.println(x); 
//  Offer 1 related Topology
    if(x.equalsIgnoreCase("offer1")){                   
       String y="", z="";
       bu = new TopologyBuilder();          
       bu.setSpout();
       y = x+"start";
       cluster.submitTopology(x,config,bu.createTopology());
    }

//      Offer 2 related Topology

 if(x.equalsIgnoreCase("off2")){

       String y="", z="";
       bu = new TopologyBuilder();          
       bu.setSpout(x, new Off1Spout(x).ks(), 2);
       y = x+"start";
       bu.setBolt(y, new off2Bolt()).shuffleGrouping(x);
       cluster.submitTopology(x,config,bu.createTopology());
  }
}