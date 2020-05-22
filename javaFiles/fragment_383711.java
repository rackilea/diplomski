summary = new ArrayList<WorkoutPlanBean>();
    beans = dao.getAppropriationSummaryBySor(criteria, summary);

    WorkoutPlanBean valuecTotals = new WorkoutPlanBean();
    valuecTotals.setSor(VALUEC_TOTALS_SOR);

    WorkoutPlanBean globalTotals = new WorkoutPlanBean();
    globalTotals.setSor(GRAND_TOTALS_SOR);

    int nbMdmc = 0; // to count VALUEA & VALUEB to know if a total is needed
    int lastMdmcIndex = 0;

    for (int i=0; i< summary.size(); i++)
    {
        WorkoutPlanBean bean = summary.get(i);

        //We need 2 beans...one with VALUEA and one with VALUEB
        if( bean.getSor().getShortName().equals("VALUEA") || bean.getSor().getShortName().equals("VALUEB"))
        {
            lastMdmcIndex = i;
            // count VALUEA and VALUEB
            nbMdmc++;

            // add to valuec total
            valuecTotals.setQuantity(Overview.totalsIntegerAdd(valuecTotals.getQuantity(),
                                                               bean.getQuantity()));
            valuecTotals.setHours(Overview.totalsDoubleAdd(valuecTotals.getHours(),
                                                                bean.getHours()));
            valuecTotals.setValue(Overview.totalsBigDecimalAdd(valuecTotals.getValue(),
                                                                bean.getValue()));
        }

        // add to grand total
        globalTotals.setQuantity(Overview.totalsIntegerAdd(globalTotals.getQuantity(),
                                                               bean.getQuantity()));
        globalTotals.setHours(Overview.totalsDoubleAdd(globalTotals.getHours(),
                                                                bean.getHours()));
        globalTotals.setValue(Overview.totalsBigDecimalAdd(globalTotals.getValue(),
                                                                bean.getValue()));

    }

    if(nbMdmc > 1) summary.add(lastMdmcIndex+1, valuecTotals); 

    if(summary.size() > 1) summary.add(globalTotals); 


request.setAttribute("summary", summary);