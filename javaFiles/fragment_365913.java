case "TOP DOWN BUDGET":
    List<TaskDetails> timeLine=getTimeLine("firstDropDownA", second_drop_down_val, third_drop_down_val, fourth_drop_down_val);
    workPlanReportList=setWorkPlanByTimeLine(timeLine, "firstDropDownA", second_drop_down_val, third_drop_down_val, fourth_drop_down_val);
    break;
case "TEMPLATE BUDGET":
    List<TaskDetails> timeLine=getTimeLine("firstDropDownB", second_drop_down_val, third_drop_down_val, fourth_drop_down_val, fifth_dd_val);
    workPlanReportList=setWorkPlanByTimeLine(timeLine, "firstDropDownA", second_drop_down_val, third_drop_down_val, fourth_drop_down_val);
    break;
 ...