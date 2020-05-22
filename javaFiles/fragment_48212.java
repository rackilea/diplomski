// imports
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

// code flow
// HttpServletRequest request
final FileItemFactory factory = new DiskFileItemFactory();
final ServletFileUpload fileUpload = new ServletFileUpload(factory);
List items = null;
private Map<String, InputStream> fileMap = new HashMap<String, InputStream>();

if (ServletFileUpload.isMultipartContent(request)) {

    // get the request content and iterate through
    items = fileUpload.parseRequest(request);

    if (items != null) {
        final Iterator iter = items.iterator();
        while (iter.hasNext()) {
            final FileItem item = (FileItem) iter.next();
            // this is for non-file fields
            if (item.isFormField()) {

            // logic for setting non-file fields
            } else {
                // item.getName() - gives file name
                fileMap.put(item.getName(), item.getInputStream());
            }
        }
    }
}

//Here i will insert that images on by one to DB
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/raptor1_5","root","");

Set<String> keySet = fileMap.keySet();
for (String fileName : keySet) {

String sql = "INSERT INTO contacts (photo) values (?)";  
PreparedStatement statement = con.prepareStatement(sql);  
statement.setBlob(1, fileMap.get(fileName));  
int row = statement.executeUpdate();  
}