@RemoteServiceRelativePath("BestCookiesService")
public interface BestCookiesService extends RemoteService {

   // methods
   // Cookie should implement IsSerializable
   Cookie[] getBestCookies(); 

}