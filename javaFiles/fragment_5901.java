import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    Type collectionType = new TypeToken<ArrayList<ArticleContainer>>() {}.getType();
    ArrayList<ArticleContainer> articles = gson.fromJson(new FileReader("input.json"), collectionType);
    System.out.println(gson.toJson(articles));
  }
}

class ArticleContainer
{
  Article article;
}

class Article
{
  public int author_id;
  public String body;
  public String catagory;
  public String created_at;
  public int id;
  public String published;
  public String updated_at;
}