%typemap(jstype) sockaddr_in *make_stuff "java.net.InetSocketAddress"
%typemap(javaout) sockaddr_in *make_stuff {
  long cPtr = $jnicall;
  sockaddr_in s = new sockaddr_in(cPtr, true);
  byte[] bytes = new byte[4];
  for (int i = 0; i < 4; ++i) {
    bytes[i] = (byte)s.getAddr(i);
  }
  java.net.InetAddress addr = null;
  try {
    addr = java.net.InetAddress.getByAddress(bytes);
  }
  catch (java.net.UnknownHostException e) {
    return null;
  }
  return new java.net.InetSocketAddress(addr, s.getPort());
}

%immutable;
struct sockaddr_in{
   %rename(family) sin_family;
   short sin_family;
   %extend {
     unsigned short getPort() const {
       return ntohs($self->sin_port);
     }
     char getAddr(int byte) const {
       const char *ptr = reinterpret_cast<const char*>(&$self->sin_addr.s_addr);
       return ptr[byte];
     }
   }
};
%mutable;

void do_stuff(sockaddr_in *ADDR);