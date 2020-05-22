function view__id1__id2_clientSide_onclick(thisEvent) {
 alert('you clicked?'); 

}

XSP.addOnLoad(function() {
XSP.attachEvent("view:_id1:_id2", "view:_id1:button1", "onclick",     
  view__id1__id2_clientSide_onclick, false, 2);
});