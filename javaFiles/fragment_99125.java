import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyTag extends BodyTagSupport {

    private String name;
    private int counter;

    public int doStartTag() throws JspException {
        counter = 1;
        JspWriter out = pageContext.getOut();
        try {
            out.print(name);
            pageContext.setAttribute("valueOfK", counter);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doAfterBody() {
        counter++;
        if (counter == 10) {
            return SKIP_BODY;
        } else {
            JspWriter out = pageContext.getOut();
            try {
                StringBuilder names = new StringBuilder();
                for (int k = 0; k < counter; k++) {
                    names.append(name).append(" ");
                }
                out.print(names.toString());
                pageContext.setAttribute("valueOfK", counter);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return EVAL_BODY_AGAIN;
        }
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}