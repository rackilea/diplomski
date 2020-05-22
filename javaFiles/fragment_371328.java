package org.apache.http.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.util.EntityUtils;

public class HttpExample {

    // RFC 822

    public static void main(String[] args) throws IOException, HttpException {
        String str = "POST http://localhost:8080/foobar/1234567 HTTP/1.1\n" +
            "Message-ID: <19815303.1075861029555.JavaMail.ss@kk>\n" +
            "Date: Wed, 6 Mar 2010 12:32:20 -0800 (PST)\n" +
            "From: someone@someotherplace.com\n" +
            "To: someone@someplace.com\n" +
            "Subject: some subject\n" +
            "Mime-Version: 1.0\n" +
            "Content-Type: text/plain; charset=us-ascii\n" +
            "Content-Transfer-Encoding: 7bit\n" +
            "X-From: one, some <some.one@someotherplace.com>\n" +
            "X-To: one\n" +
            "X-cc: \n" +
            "X-bcc: \n" +
            "X-Origin: Bob-R\n" +
            "X-FileName: rbob (Non-Privileged).pst\n" +
            "Content-Length: 13\n" +
            "\n" +
            "some message\n";
        ByteArrayInputStream fakeStream = new ByteArrayInputStream(
                str.getBytes());

        BHttpConnectionBaseImpl b = new BHttpConnectionBaseImpl(fakeStream);

        BasicHttpEntityEnclosingRequest request1 = (BasicHttpEntityEnclosingRequest) b.receiveRequestHeader();
        b.receiveRequestEntity(request1);


        for (Header hdr : request1.getAllHeaders()) {
            System.out.println(String.format("%-30s = %s", hdr.getName(), hdr.getValue()));
        }
        System.out.println(String.format("Request Line: %s", request1.getRequestLine()));
        System.out.println(String.format("Body\n------------------\n%s",
                EntityUtils.toString( request1.getEntity() ) ));
    }

}

class BHttpConnectionBaseImpl extends  org.apache.http.impl.DefaultBHttpServerConnection{

    private InputStream inputStream;

    public BHttpConnectionBaseImpl(final InputStream inputStream) {
        super(4048);
        this.inputStream = inputStream;
        try {
            super.bind(new Socket());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected InputStream getSocketInputStream(final Socket socket) throws IOException {
        return inputStream;
    }

    @Override
    protected OutputStream getSocketOutputStream(final Socket socket) throws IOException {
        return new ByteArrayOutputStream();
    }
}