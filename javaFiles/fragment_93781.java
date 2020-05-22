@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@RequestMapping // meta-annotated RequestMapping 
@MessageMapping // meta-annotated MessageMapping
public @interface ApiController {

     @AliasFor(annotation = RequestMapping.class, attribute = "value") // -> alias for RequestMapping value attribute
     String[] value() default {};

     @AliasFor(annotation = MessageMapping.class, attribute = "value") // -> alias for MessageMapping value attribute
     String[] mvalue() default{};   
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@RequestMapping
@MessageMapping
public @interface ApiMapping {

    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};

    @AliasFor(annotation = MessageMapping.class, attribute = "value")
    String[] mvalue() default {};

    @AliasFor(annotation = RequestMapping.class, attribute = "method")
    RequestMethod[] method() default {};
}