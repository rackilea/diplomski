StringBuffer sb = new StringBuffer("<table>");
    for (int index = 0; index < (intAmortizationPeriod * 12); index++) {

        LoanSchedule loanSchedule = loanScheduleArray[index];
        sb.append("<tr><td>");
        sb.append(loanSchedule.toString());
        sb.append("</td></tr>");
    }
    sb.append("</table>");
    response.getWriter().println(sb.toString());

You can still format the toString method as needed