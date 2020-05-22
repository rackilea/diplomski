You need to calculate the coordinates of the page by width and height 
May be it will help you..

Long width=(long) pdfReader.getPageSize(i).getWidth();
Long height=(long) pdfReader.getPageSize(i).getHeight();

if (pdfReader.getPageRotation(i) % 180 == 0) {
                        x = width / 2;
                        y = height - 20;
                    }
                    else {
                        x = width / 2;
                        y = height - 20;
                    }

ColumnText.showTextAligned(pdfStamper.getOverContent(i), Element.ALIGN_CENTER, header, x, y+3, 0);