@Configuration
public class DocxToHtmlConverterConfig{
  @Bean
  public DocxToHtmlConverter docxToHtmlConverter(){
    return new DocxToHtmlConverter();
  }
}