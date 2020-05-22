%typemap(jni) sockaddr_in *ADDR "jobject"
%typemap(jtype) sockaddr_in *ADDR "java.net.InetSocketAddress"
%typemap(jstype) sockaddr_in *ADDR "java.net.InetSocketAddress"

%typemap(in) (sockaddr_in *ADDR) {
  $1 = new sockaddr_in;
  $1->sin_family = AF_INET;
  jclass inetsockaddr = jenv->FindClass("java/net/InetSocketAddress");
  assert(inetsockaddr);
  // TODO: check return
  jmethodID pmid,addrmid,ipbytemid;
  pmid = jenv->GetMethodID(inetsockaddr, "getPort", "()I");
  assert(pmid);
  jint port = jenv->CallIntMethod($input, pmid);
  $1->sin_port = htons(port);
  jclass inetaddr = jenv->FindClass("java/net/InetAddress");
  assert(inetaddr);
  addrmid = jenv->GetMethodID(inetsockaddr, "getAddress", "()Ljava/net/InetAddress;");
  assert(addrmid);
  jobject addrobj = jenv->CallObjectMethod($input, addrmid);
  assert(addrobj);
  ipbytemid = jenv->GetMethodID(inetaddr, "getAddress", "()[B");
  assert(ipbytemid);
  jbyteArray barr = static_cast<jbyteArray>(jenv->CallObjectMethod(addrobj, ipbytemid));
  assert(barr);
  jbyte *bytes = jenv->GetByteArrayElements(barr, 0);
  assert(bytes);
  memcpy(&$1->sin_addr.s_addr, bytes, 4);
  $1->sin_addr.s_addr = htonl($1->sin_addr.s_addr);
  jenv->ReleaseByteArrayElements(barr, bytes, JNI_ABORT); // No changes copied back
}

%typemap(freearg) (sockaddr_in *ADDR) {
  delete $1;
}

%typemap(javain) sockaddr_in *ADDR "$javainput"