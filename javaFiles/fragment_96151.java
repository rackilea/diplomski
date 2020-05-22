public class HttpsURLConnectionImpl {
   protected DelegateHttpsURLConnection delegate;
   public boolean equals(Object obj) {
    return delegate.equals(obj);
   }
}