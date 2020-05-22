package mypackage;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CopyResponseFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // NOOP.
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
        throws IOException, ServletException
    {
        // Set character encoding for better world domination.
        response.setCharacterEncoding("UTF-8");

        // Create copy writer.
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        CopyWriter copyWriter = new CopyWriter(new OutputStreamWriter(
            httpResponse.getOutputStream(), httpResponse.getCharacterEncoding()));

        // Filter request with response which is wrapped with new writer.
        chain.doFilter(request, wrapResponse(httpResponse, copyWriter));

        // Store the copy writer afterwards in session so that it's available in next request.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpRequest.getSession().setAttribute("copyWriter", copyWriter);
    }

    public void destroy() {
        // NOOP.
    }

    private static HttpServletResponse wrapResponse
        (final HttpServletResponse response, final PrintWriter writer)
    {
        return new HttpServletResponseWrapper(response) {
            public PrintWriter getWriter() throws IOException {
                return writer;
            }
        };
    }

}

class CopyWriter extends PrintWriter {

    StringBuilder copy = new StringBuilder();

    public CopyWriter(Writer out) {
        super(out);
    }

    public void write(int c) {
        copy.append((char) c); // It is actually a char, not an int.
        super.write(c);
        super.flush();
    }

    public void write(char[] chars) {
        copy.append(chars);
        super.write(chars);
        super.flush();
    }

    public void write(char[] chars, int offset, int length) {
        copy.append(chars, offset, length);
        super.write(chars, offset, length);
        super.flush();
    }

    public void write(String string) {
        copy.append(string);
        super.write(string);
        super.flush();
    }

    public void write(String string, int offset, int length) {
        copy.append(string, offset, length);
        super.write(string, offset, length);
        super.flush();
    }

    public String getCopy() {
        return copy.toString();
    }

}