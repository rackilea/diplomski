DataRecord newData = new DataRecord(" Hello "," world! ");
stackArray.push(newData);

System.out.println("Results : " + stackArray.toString());

newData.setIDandData("why","omg");
stackArray.push( newData );