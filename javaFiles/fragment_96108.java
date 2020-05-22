Object certChain = request.getAttribute(
            "javax.servlet.request.X509Certificate");
       if (certChain != null) {
          X509Certificate certs[] = (X509Certificate[])certChain;
          X509Certificate cert = certs[0];
          String n = cert.getSubjectDN().getName();
        }