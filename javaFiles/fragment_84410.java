@Data
@ConfigurationProperties(prefix="category")
public class MyProperties{

private CategoryPojo aaa;
private CategoryPojo bbb;
private CategoryPojo ccc;
private CategoryPojo ddd;


@Data    
public static class CategoryPojo{
    private String valueOne;
    private String valueTwo;

}


}