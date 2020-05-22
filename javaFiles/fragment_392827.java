public void changeVal(ValueChangeEvent vce) {
    // Add event code here...
    Integer selectedCode=null;
   //As we get indexes not value of LOV so need to map selected index with value.

    if (vce.getNewValue() != null) {
        this.setvalueToExpression("#{bindings.item_emp_id.inputValue}",
                                  vce.getNewValue()); //Updating Model Values
         selectedCode =
            Integer.parseInt(this.getValueFrmExpression("#{bindings.item_emp_id.attributeValue}").toString());

        System.out.println("******** Selected Value in List***** " +
                           selectedCode);
        System.out.println("*******Display Value in List ****" +
                           getValueFrmExpression("#{bindings.item_emp_id.selectedValue.attributeValues[1]}"));
    }

    String e_id=selectedCode.toString(); //It will contain selected item_emp_id
    DCBindingContainer bindings =
    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    DCIteratorBinding dcIteratorBindings =
    bindings.findIteratorBinding("EmpView1Iterator"); // Base table Emp VO iterator
    DCIteratorBinding dcIteratorBindings1 =
    bindings.findIteratorBinding("empViewObj1Iterator"); // LOV table Emp Vo iterator
    ViewObject vo = dcIteratorBindings.getViewObject();
    ViewObject vo1 = dcIteratorBindings1.getViewObject();
    Row  r1 = vo.getCurrentRow(); // get current row of base table VO


    vo1.setWhereClause("e_id = " + e_id); // set where clause to get the description from LOV in VO1
    vo1.executeQuery(); //execute it.
    if(vo1.hasNext())
    {
    Row r=vo1.next(); // Get the row from LOV VO

    if(r!=null)
    {
       r1.setAttribute("item_emp_desc", r.getAttribute("EmpName")); //set it to item_emp_desc which is a transient variable for output.
    }
    }

}


    public void setvalueToExpression(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);
        exp.setValue(elContext, val);
    }


 public String getValueFrmExpression(String data) {
FacesContext fc = FacesContext.getCurrentInstance();
Application app = fc.getApplication();
ExpressionFactory elFactory = app.getExpressionFactory();
ELContext elContext = fc.getELContext();
ValueExpression valueExp = elFactory.createValueExpression(elContext, data, Object.class);
String Message = null;
Object obj = valueExp.getValue(elContext);
        if (obj != null) {
Message = obj.toString();
        }
        return Message;
    }