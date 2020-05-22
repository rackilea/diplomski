ArrayList listVal = new ArrayList(20);
listVal.add(101);
listVal.add(102);
// Set List as value
selectMcBind.setValue(listVal.toArray());
//Refresh Component on page (partial target)
AdfFacesContext.getCurrentInstance().addPartialTarget(selectMcBind);