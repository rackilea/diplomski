Local JavaObject &joCertString, &joUrl, &joUrlConnection, &joInputStream, &joImageIO, &joBufferedImage, &joFile;
Local JavaObject &joCertificateFactoryClass, &joCertificateFactory, &joCertInputStream, &joCertificate;
Local JavaObject &joKeystoreClass, &joKeystore, &joTrustManagerFactoryClass, &joTrustManagerFactory;
Local JavaObject &joSSLContextClass, &joSSLContext, &joSSLFactory, &joCastObjectClass;
Local any &anyFileData;
Local Record &recTest;
Local string &sPhotosCert;
Local number &nPutResult;

/*Setup CertificateFactory*/
&sPhotosCert = GetHTMLText(HTML.PHOTOS_CERT);
&joCertString = CreateJavaObject("java.lang.String", &sPhotosCert);
&joCertificateFactoryClass = GetJavaClass("java.security.cert.CertificateFactory");
&joCertificateFactory = &joCertificateFactoryClass.getInstance("X.509");
&joCertInputStream = CreateJavaObject("java.io.ByteArrayInputStream", &joCertString.getBytes("UTF-8"));
&joCertificate = &joCertificateFactory.generateCertificate(&joCertInputStream);

/*Create Keystore*/
&joKeystoreClass = GetJavaClass("java.security.KeyStore");
&joKeystore = &joKeystoreClass.getInstance("JKS");
&joKeystore.load( Null, Null);
&joKeystore.setCertificateEntry("photos", &joCertificate);

/*Create TrustManagerFactory*/
&joTrustManagerFactoryClass = GetJavaClass("javax.net.ssl.TrustManagerFactory");
&joTrustManagerFactory = &joTrustManagerFactoryClass.getInstance(&joTrustManagerFactoryClass.getDefaultAlgorithm());
&joTrustManagerFactory.init(&joKeystore);

/*Create SSLContext and get SSLSocketFactory*/
&joSSLContextClass = GetJavaClass("javax.net.ssl.SSLContext");
&joSSLContext = &joSSLContextClass.getInstance("TLS");
&joSSLContext.init( Null, &joTrustManagerFactory.getTrustManagers(), Null);
&joSSLFactory = &joSSLContext.getSocketFactory();

/*Create URL*/
&joUrl = CreateJavaObject("java.net.URL", "https://domain.com/handler.ashx?id=123456");

/*Get URLConnection*/
&joUrlConnection = &joUrl.openConnection();

/*Cast to HttpsURLConnection*/
&joCastObjectClass = GetJavaClass("com.domain.CastObject");
&joUrlConnection = &joCastObjectClass.objectToHttpsURLConnection(&joUrlConnection);

/*Set connection properties*/
&joUrlConnection.setSSLSocketFactory(&joSSLFactory);
&joUrlConnection.setRequestMethod("GET");

/*Get InputStream*/
&joInputStream = GetJavaClass("java.io.InputStream");
&joInputStream = &joUrlConnection.getInputStream();

/*Get Image From Stream*/
&joImageIO = GetJavaClass("javax.imageio.ImageIO");
&joBufferedImage = CreateJavaObject("java.awt.image.BufferedImage", 1, 1, 1);
&joBufferedImage = &joImageIO.read(&joInputStream);

/*Write Image to File*/
&joFile = CreateJavaObject("java.io.File", "/temp/URLImage2.jpg");
&joImageIO.write(&joBufferedImage, "jpg", &joFile);

/*Put the File into a PS record so we can get a BLOB of it*/
&nPutResult = PutAttachment("record://PSFILE_ATTDET", "013505.jpg", "/temp/URLImage2.jpg");

/*Grab that BLOB*/
SQLExec("SELECT FILE_DATA FROM PSFILE_ATTDET WHERE ATTACHSYSFILENAME = :1 AND VERSION = 1", "013505.jpg", &anyFileData);

/*Clean up the temp row we inserted*/
SQLExec("DELETE FROM PSFILE_ATTDET WHERE ATTACHSYSFILENAME = :1 AND VERSION = 1", "013505.jpg");

/*Setup an employee photo record*/
&recTest = CreateRecord(Record.EMPL_PHOTO);
&recTest.EMPLID.Value = "013505";
&recTest.PSIMAGEVER.Value = (Days365(Date3(1999, 12, 31), %Date) * 86400) + (%Time - Time3(0, 0, 0));
&recTest.EMPLOYEE_PHOTO.Value = &anyFileData;

/*Insert/Update the employee photo record*/
&recTest.Insert();
&recTest.Update();