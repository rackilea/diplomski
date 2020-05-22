JasperDesign jasperDesign = new JasperDesign();

//Some code to filling bands .....

JRDesignBand band = new JRDesignBand();
band.setHeight(200);

//The expression must contain the double quotes!!! 
//This is a analogue of <imageExpression><![CDATA["watermark.png"]]></imageExpression>
String imgPath = "\"watermark.png\"";

JRDesignExpression expression = new JRDesignExpression();
expression.setText(imgPath);

JRDesignImage image = new JRDesignImage(jasperDesign);
image.setX(45);
image.setY(55);
image.setWidth(165);
image.setHeight(40);
//We can use another scaling mode
image.setScaleImage(ScaleImageEnum.FILL_FRAME);
image.setExpression(expression);

//Adds image to the band
band.addElement(image);

//Adds band as background 
jasperDesign.setBackground(band);