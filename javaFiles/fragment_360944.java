@Configuration
    @Controller
    public class MyController 
    {

      @Value("${name}")
      private String name;

      @Value("${maxButtonQuantity}")
      private int maxButtonQuantity;

      ................

     //* pass the value to PageWrapper after you instantiate it,
     pageWrapper.setMaxButtonQuantity(maxButtonQuantity);

    }

    public class PageWrapper<T> {

      private int maxButtonQuantity = **I want to put here the property from file**;
      private Page<T> page;
      private List<PageItem> buttons;
      private int currentNumber;
      private String url;

      public void setMaxButtonQuantity(int maxButtonQuantity)
      {
        this.maxButtonQuantity = maxButtonQuantity;
      }

    }