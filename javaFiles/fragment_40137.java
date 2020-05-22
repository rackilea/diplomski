PDPage page = (PDPage)allPages.get( i );
PDRectangle pageSize = page.findMediaBox();
PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true,true);
page.getResources().getFonts();  // <<<<<<<<
PDFont font = PDType1Font.TIMES_ROMAN;
float fontSize = 15.0f;
contentStream.beginText();