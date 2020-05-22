<%

      //prepare trendlines
       ArrayList trendlines= new ArrayList();
       trendlines.add(buildTrendlines("startvalue","color","displayvalue",gson));

        //close the connection.
        result.close();


        //create 'dataMap' map object to make a complete FusionCharts datasource.
         Map<String, String> dataMap = new LinkedHashMap<String, String>();  
    /*
        gson.toJson() the data to retrieve the string containing the
        JSON representation of the data in the array.
    */
         dataMap.put("chart", gson.toJson(chartobj));
         dataMap.put("categories", gson.toJson(categories));
         dataMap.put("dataset", gson.toJson(dataset));
         dataMap.put("trendlines",gson.toJson(trendlines));
        FusionCharts mslineChart= new FusionCharts(
        "msline",// chartType
                    "chart1",// chartId
                    "600","400",// chartWidth, chartHeight
                    "chart",// chartContainer
                    "json",// dataFormat
                    gson.toJson(dataMap) //dataSource
                );

        %>


        <%!


        public Map buildTrendlines(String startvalue, String color, String displayvalue, Gson gson){

               Map<String, String> trendlineinner = new HashMap<String, String>();
                 ArrayList lines = new ArrayList();
                    Map<String, String> linesdata = new HashMap<String, String>();  
                  linesdata.put("startvalue", "17022");
                  linesdata.put("color","#6baa01");
                   linesdata.put("displayvalue","Average");
                  lines.add(linesdata);  
                trendlineinner.put("line", gson.toJson(lines));
                return trendlineinner;
                 }
                 %>