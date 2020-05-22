public class BestCookiesServiceImpl extends RemoteServiceServlet implements BestCookiesService {

    // you can access your DAOs here
    @Override
    public Cookie[] getBestCookies() {
         BestCookiesDAO dao = getBestCookiesDAO();
         BestCookiesList list = dao.getBestCookies();

         Cookie[] array = new Cookie[list.size()];
         for (int i = 0; i < list.size(); i++) {
             array[i] = new Cookie(list.get(i).getIngredients());
         }

         return array;
    }

}