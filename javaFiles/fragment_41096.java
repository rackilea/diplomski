info.append("<html><table>");

for (TResult result : results)
    info.append("<tr><td>"+result.getID()+"</td><td>"+result.getApprovalDateStr+"</td><td>"+result.getState+","+result.getCity()+"</td></tr>");

info.append("</table></html>");

//then
textPane.setText(info.toString());