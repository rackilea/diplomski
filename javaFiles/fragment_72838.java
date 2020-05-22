import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
// and other required classess
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    if (!ServletFileUpload.isMultipartContent(request)) {
        throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
    }

    MultipartParser mp = new MultipartParser(request, 10*1024*1024); //10MB
    Part part;
    while ((part = mp.readNextPart()) != null) {
    String name = part.getName();
    if (part.isParam()) {
      // it's a parameter part
      ParamPart paramPart = (ParamPart) part;
      String value = paramPart.getStringValue();
      fileWriter.println("param; name=" + name + ", value=" + value);
    }
    else if (part.isFile()) {
      // it's a file part
      FilePart filePart = (FilePart) part;
      String fileName = filePart.getFileName();
      if (fileName != null) {
        // the part actually contained a file
        long size = filePart.writeTo(new File("/path to save directory"+filePart.getFileName()));
        System.out.println("file; name=" + name + "; filename=" + fileName +
          ", filePath=" + filePart.getFilePath() + 
          ", content type=" + filePart.getContentType() + 
          ", size=" + size);
      }
      else { 
        // the field did not contain a file
        System.out.println("file; name=" + name + "; EMPTY");
      }
    }
  }
}