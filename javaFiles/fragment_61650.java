@RestController //or @Controller or @{any annotation that declares a component}
public class MyService{
  @Autowired
  DocxToHtmlConverter docxToHtmlConverter;

  public void convertFile(){
    docxToHtmlConverter.docxToHtml("File.docx",".File.html");
  }   
}