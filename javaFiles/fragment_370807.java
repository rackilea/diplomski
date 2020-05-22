List<GraphData> graphList = new ArrayList<GraphData>();

GraphData graphData1 = new GraphData();
graphData1.setLabe1( "A" );
graphData1.setData( yourFirstListOfData );

GraphData graphData2 = new GraphData();
graphData2.setLabel( "B" );
graphData2.setData( yourSecondListOfData );

graphList.add(graphData1);
graphList.add(graphData2);

Gson gson = new Gson();
String json = gson.toJson( graphList );

// prints the generated json
System.out.println( json );