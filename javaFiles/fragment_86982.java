public int doStartTag() throws JspException {
// some code here
ArrayList<Row> rowList = new ArrayList<>();
  while(set.next()){
     //pageContext.getOut().print("<br>" + set.getString("empName"));
       Row currRow = new Row();
       currRow.setValue(set.getString("empName"));
       rowList.add(currRow);
  }
 pageContext.setAttribute("result", rowList);
 // some more code 
}