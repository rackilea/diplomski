<%
if (session.isNew()) {
    counter.saveCount();
} else {
    counter.setCoun(-1);
}
int _numberofvisitors=counter.getVisitorsNumber();
out.println(_numberofvisitors);
%>