<select name="subject_id">
<%
  for (Object subjectObject : subjectList) {
      subject subject = (Subject) subjectObject;
%>
      <option value="<%=subject.getId()%>"><%=subject.getName()%></option>
<%
  } //end for
%>
</select>