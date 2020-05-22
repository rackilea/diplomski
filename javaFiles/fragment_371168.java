import java.security.cert.X509Certificate;
......

Object o = request.getAttribute("javax.servlet.request.X509Certificate");
    X509Certificate[] certs = (X509Certificate[]) o;
    X509Certificate cert = certs[0];