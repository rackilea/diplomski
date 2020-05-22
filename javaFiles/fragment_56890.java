public class Invoice {
    ArrayList<Article> detailList = new ArrayList<Article>();
    public void add(Article a) {
         detailList.add(a);
    }
    public ArrayList<Article> getArticleList(){
          return detailList;
    }
}