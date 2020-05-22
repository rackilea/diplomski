List<String> interviewTimingToFrom1 = Arrays.asList(interviewTime1.split(","));
List<String> interviewTimingToFrom2 = Arrays.asList(interviewTime2.split(","));
List<String> listOfinterviewerName = Arrays.asList(intervierwName.split(","));

StringBuilder buf = new StringBuilder();
buf.append("<html>" +
           "<body>" +
           "<table>" +
           "<tr>" +
           "<th>Interviewe</th>" +
           "<th>Timing1</th>" +
           "<th>Timing2</th>" +
           "</tr>");
for (int i = 0; i < listOfinterviewerName.size(); i++) {
    buf.append("<tr><td>")
       .append(listOfinterviewerName.get(i))
       .append("</td><td>")
       .append(interviewTimingToFrom1.get(i))
       .append("</td><td>")
       .append(interviewTimingToFrom2.get(i))
       .append("</td></tr>");
}
buf.append("</table>" +
           "</body>" +
           "</html>");
String html = buf.toString();