private String styleForCell;

public String getStyleForCell()
{
    // get the value of the cell
    FacesContext lContext = FacesContext.getCurrentInstance();
    ELContext lELContext = lContext.getELContext();
    ExpressionFactory lExpressionFactory = lContext.getApplication().getExpressionFactory();
    Number val;
    val = (Number) lExpressionFactory.createValueExpression(lELContext, "#{row.valargument}", Object.class).getValue(lELContext);
    if (val == null)
        return "";

    // do the calculation and return the suitable style class
    int ival = val.intValue();
    if (ival >= 100000 )
        return "high_value";
    else if (ival < 0)
        return "negative_value";
    else 
        return "";         
}

public void setStyleForCell(String aStyleForCell)
{
    this.styleForCell = aStyleForCell;
}