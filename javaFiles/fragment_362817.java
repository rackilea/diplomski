@Override
protected void processOperator(Operator operator, List<COSBase> operands)  throws IOException {
    String operation = operator.getName();
    if ("Do".equals(operation)) {
        COSName objectName = (COSName) operands.get(0);
        PDXObject xobject = getResources().getXObject(objectName);
        if (xobject instanceof PDImageXObject) {
             PDImageXObject image = (PDImageXObject) xobject;
             Matrix ctmNew = getGraphicsState().getCurrentTransformationMatrix();
             float imageXScale = ctmNew.getScalingFactorX();
             float imageYScale = ctmNew.getScalingFactorY();
             // position in user space units. 1 unit = 1/72 inch at 72 dpi
             System.out.println("position in PDF = " + ctmNew.getTranslateX() + ", " + ctmNew.getTranslateY() + " in user space units");
             // displayed size in user space units
             System.out.println("displayed size  = " + imageXScale + ", " + imageYScale + " in user space units");
        } else if (xobject instanceof PDFormXObject) {
             PDFormXObject form = (PDFormXObject) xobject;
             showForm(form);
        }
    } else {
        super.processOperator(operator, operands);
    }
}