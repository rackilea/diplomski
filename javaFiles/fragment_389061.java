protected final String getCriteriaHeader(MetricFilterCriteriaForm form)
{
    StringBuilder filterCriteria = new StringBuilder("<br/>");
    if (form.isSacNone() || form.isSac1() || form.isSac2() || form.isSac3())
    {
        filterCriteria.append("SAC:");
        if (form.isSacNone())
            filterCriteria.append(" NONE");
        if (form.isSac1() || form.isSac2() || form.isSac3())
        {
            if (form.isSac1())
                filterCriteria.append(" 1,");
            if (form.isSac2())
                filterCriteria.append(" 2,");
            if (form.isSac3())
                filterCriteria.append(" 3,");
            if(','==filterCriteria.charAt(filterCriteria.length-1) )
                filterCriteria.deleteCharAt(filterCriteria.length-1)
            filterCriteria.append("<br/>");
        }
    }
    if (form.isRegularScheduleType() || form.isLotScheduleType() || form.isBatchScheduleType())
    {
        filterCriteria.append("Schedule Type:");
        if (form.isRegularScheduleType())
            filterCriteria.append(" Regular,");
        if (form.isLotScheduleType())
            filterCriteria.append(" Lot,");
        if (form.isBatchScheduleType())
            filterCriteria.append(" Batch,");
        if(','==filterCriteria.charAt(filterCriteria.length-1) )
            filterCriteria.deleteCharAt(filterCriteria.length-1)
    }
    return filterCriteria.toString();
}