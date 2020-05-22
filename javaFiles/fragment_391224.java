JSONObject report = new JSONObject();
    report.put("reportId", "my_report");
    report.put("name", "my_name");

    //define json array to represent your sub report array
    JSONArray subReportArr = new JSONArray();

    JSONObject subReport1 = new JSONObject();                       
    subReport1.put("id", "144");
    subReport1.put("reportId", "10");
    subReport1.put("name", "my_name10");
    //put subreport object to array
    subReportArr.put(subReport1);

    //for subReportn create JSONObject and populate with required data
    JSONObject subReportn = new JSONObject();
    //then put into parent JSONArray
    subReportArr.put(subReportn);

   //put subReport array to main report object
    report.put("subReport", subReportArr);

    String jsonStr = report.toString();
    //then print out
    System.out.println(jsonStr);