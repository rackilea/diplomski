<script>
function onCallForInterview()
{
var selectedIds;
var count=0;
for (i=0; i<document.frm.check1.length; i++)
{
if (document.frm.check1[i].checked==true)
{
if(count==0){
selectedIds=document.frm.check1[i].value; 
count=count+1; 
}
else
selectedIds=selectedIds+","+document.frm.check1[i].value;
}
}
alert(selectedIds);  
document.frm.action="<%=contextPath%>/SearchCandInfo?    action=selectcanforinterview&ids="+selectedIds;
document.frm.submit();
}
</script>