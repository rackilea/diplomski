ELContext elContext =  pageContext.getELContext();
JspFactory jf = JspFactory.getDefaultFactory();
JspApplicationContext jac = jf
                 .getJspApplicationContext(pageContext.getServletContext());
ExpressionFactory ef = jac.getExpressionFactory();
ValueExpression val = ef.createValueExpression(elContext, "your expression", resultClass);