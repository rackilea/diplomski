public class Bean{

   @JsonSerialize(using=DescriptionSerializer.class)
   private String description

}