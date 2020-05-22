//if you would have a chapter indentation
int indentation = 0;
//whatever
Image image = coolPic;

float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
               - document.rightMargin() - indentation) / image.getWidth()) * 100;

image.scalePercent(scaler);