import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;

    import org.apache.commons.lang.ArrayUtils;
    import org.springframework.mock.web.MockHttpServletResponse;
    import org.springframework.mock.web.MockMultipartFile;
    import org.springframework.mock.web.MockMultipartHttpServletRequest;


public class FileUploadTest {

    public void testDoPost() throws IOException {
            Path path = Paths.get("c:\\temp\\test.zip");
            byte[] data = Files.readAllBytes(path);
            MockMultipartFile file = new MockMultipartFile("test.zip", "test.zip",
                    "application/zip", data);
            MockMultipartHttpServletRequest mockRequest = new MockMultipartHttpServletRequest();
            String boundary = "q1w2e3r4t5y6u7i8o9";
            mockRequest.setContentType("multipart/form-data; boundary="+boundary);
            mockRequest.setContent(createFileContent(data,boundary,"application/zip","test.zip"));
            mockRequest.addFile(file);
            mockRequest.setMethod("POST");
            mockRequest.setParameter("variant", "php");
            mockRequest.setParameter("os", "mac");
            mockRequest.setParameter("version", "3.4");
            MockHttpServletResponse response = new MockHttpServletResponse();
            new FileUpload().doPost(mockRequest, response);
        }

        public byte[] createFileContent(byte[] data, String boundary, String contentType, String fileName){
            String start = "--" + boundary + "\r\n Content-Disposition: form-data; name=\"file\"; filename=\""+fileName+"\"\r\n"
                     + "Content-type: "+contentType+"\r\n\r\n";;

            String end = "\r\n--" + boundary + "--"; // correction suggested @butfly 
            return ArrayUtils.addAll(start.getBytes(),ArrayUtils.addAll(data,end.getBytes()));
        }
}