@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
// Unavailable through reflection.
public @interface classbug {}
// gives you the @classbug annotation.

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)// Unavailable through reflection.
public @interface methodbug {}
// gives you the @methodbug annotation.