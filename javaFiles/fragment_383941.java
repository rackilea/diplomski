//If you only have one series all you need is this first block of code
Set<Node> node = lineChart.lookupAll(".default-color0.chart-line-symbol.series0.");                    
    node.forEach((element) -> {
      //do somthing to each node in series0
      System.out.println(element.toString());//don't know if this will work. If it does it will all you to see each node. At the very least the node address.
 });

//If you have two series you need this. If you have more thant two series you need to copy this and change node2 to node3 everywhere in your copy.
Set<Node> node2 = lineChart.lookupAll(".default-color1.chart-line-symbol.series1.");                    
    node2.forEach((element) -> {
      //do somthing to each node in series1
      System.out.println(element.toString());//don't know if this will work. If it does it will all you to see each node. At the very least the node address.
 });