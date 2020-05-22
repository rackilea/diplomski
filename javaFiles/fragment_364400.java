import java.io.IOException;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class InternalRenderer {

    private final static String ENCODE = "UTF-8";

    @Autowired
    private ViewResolver viewResolver;

    public String evalView(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale, String viewName) throws Exception {

        CustomHttpServletResponse customResponse = new CustomHttpServletResponse(response);

        View view = viewResolver.resolveViewName(viewName, locale);

        if(view != null){

            view.render(fillModelMap(model), request, customResponse);

            OutputStream os = customResponse.getOutputStream();

            return os.toString();

        }

        throw new Exception("no view found");
    }

    private Map<String, Object> fillModelMap(Model model) {

        if(model == null)
            return new HashMap<String,Object>();

        return model.asMap();
    }

    class CustomServletOutPutStream extends ServletOutputStream {

        private StringBuilder stringBuilder = new StringBuilder();

        @Override
        public String toString() {
            return stringBuilder.toString();
        }

        @Override
        public void write(int b) {
            stringBuilder.append(b);
        }

        @Override
        public void write(byte b[], int off, int len) throws IOException {
            stringBuilder.append(new String(b, off, len, ENCODE));
        }
    }

    class CustomHttpServletResponse extends HttpServletResponseWrapper {

        private ServletOutputStream outputStream;
        private PrintWriter printWriter;

        public CustomHttpServletResponse(HttpServletResponse response) throws UnsupportedEncodingException {
            super(response);

            this.outputStream = new CustomServletOutPutStream();
            this.printWriter = new PrintWriter(new OutputStreamWriter(outputStream, ENCODE));

        }

        @Override
        public ServletOutputStream getOutputStream() {
            return this.outputStream;
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return this.printWriter;
        }
    }

}