//Open an input stream to the PDF template
InputStream is = getInputStreamToEachFile();


//Declare a document object, as well as a PdfCopy for
//copying in each PdfFile we open in memory and edit.
Document doc = new Document();
PdfCopy copy = new PdfCopy(doc, outputStreamToBrowser);


//Be sure to open the document or it will throw an exception!
doc.open();


//Since the PdfStamper class wants to output everything to an
//output stream you can declare a ByteArrayOutputStream object
//and direct it there, since we need to tack on more PDFs and
//can't just output to the response's output stream directly.
ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
PdfStamper stamper = new PdfStamper(new PdfReader(is), byteStream);


//Pseduocode - set form fields - just check out
//the documentation for AcroFields in the API
//this part is easy.
...


//if form has custom graphics declare a PdfContentByte array
//the 1 argument in the getUnderContent refers to the page number

PdfContentByte cb = stamper.getUnderContent(1);

//pseduocode - do custom graphics. This can be a lot of different things,
//so check the documentation
...


//Wrap things up - set the dyanamic form fields to read only
//and call the stamper's close function to close the streams
stamper.setFormFlatterning(true);
stamper.close()


//Finally, declare a new PdfReader, reading the stamper's byte array stream
//which was declared in memory.
PdfReader outReader = new PdfReader(byteStream.toByteArray());

//Use this function call to add each page that you need. Repeat this process
//for as many PDFs as are being stitched together.
copy.addPage(copy.getImportedPage(outReader,1));

//Finally, tell the browser you are done generating the file, and output it.
//If there are a lot of pages being generated this way, I guess you could use the flush
//function instead, and then call close when they are all done.
copy.close();