if (row == HtmlTags.tags.length) {
    result += "search failed to return any results";
} else {
   result = HtmlTags.tags[row][0] + emp.getEmployeeName()
                    + HtmlTags.tags[row][1];
   result += HtmlTags.tags[row][0] + emp.getEmployeeSNo()
                    + HtmlTags.tags[row][1];
   result += HtmlTags.tags[row][0] + emp.getEmployeeDays()
                    + HtmlTags.tags[row][1];       
}