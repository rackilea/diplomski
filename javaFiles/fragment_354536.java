package struts2.stream;

import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import org.apache.struts2.convention.annotation.Result;


@Result(name = ActionSupport.SUCCESS, type = "stream", params =
{
    "contentType",
    "text/hmtl",
    "inputName",
    "inputStream",
    "contentDisposition",
    "filename=document.txt"
})
public class StreamTestAction extends ActionSupport{
    public InputStream inputStream;

    @Override
    public String execute(){
    inputStream = new StringBufferInputStream("Hello World! This is a text string response from a Struts 2 Action.");      
    return SUCCESS;
    }
}