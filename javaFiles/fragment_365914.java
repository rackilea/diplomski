private List<TaskDetails> getTimeLine(String first_Drop_Down_Value, String second_dd_val, third_dd_val, fourth_dd_val, String fifth_dd_val){

    TimePeriod timePeriod = TimePeriod.valueOf(second_Drop_Down_Value);
    DetailLevel detailLevel = DetailLevel.valueOf(third_Drop_Down_Value);

    if(fourth_dd_val.equals("Hours")){
        if(fifth_dd_val.equals("startDate"){           
          fetch(...,....,timePeriod, detailLevel) // <- pass the enums
        }
        else// means endDate{
        //prepare query & call DB for fetching days timeline for hours details of TOP DOWN BUDGET filtered by end date...
          fetch(...,....,timePeriod, detailLevel) // <- pass the enums
        }
    }
    else{//means Dollars
        if(fifth_dd_val.equals("startDate"){
        //prepare query & call DB for fetching days timeline for dollars details of TOP DOWN BUDGET filtered by start date...
          fetch(...,....,timePeriod, detailLevel) // <- pass the enums
        }
        else// means endDate{
        //prepare query & call DB for fetching days timeline for dollars details of TOP DOWN BUDGET filtered by end date...
          fetch(...,....,timePeriod, detailLevel) // <- pass the enums
        }
    }   
}