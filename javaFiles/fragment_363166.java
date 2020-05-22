public static MemberType fromWsdl(WSDLClass w) {
    if (w==null) {
      return null;
    } else {
      switch (w) {
         case WSDLClass.A: return MemberType.A;
         case WSDLClass.B: return MemberType.B;
         default: return null;
      }
    }
}