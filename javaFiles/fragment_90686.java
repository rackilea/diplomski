import java.lang.reflect.*;

 AnnotatedType baseClassAt = classOfA.getAnnotatedSuperclass();
 assert (at instanceof AnnotatedParameterizedType);

 AnnotatedType[] aTypes = ((AnnotatedParameterizedType)baseClassAt)
     .getAnnotatedActualTypeArguments();
 assert aTypes.length == 2;

 MyAnnotation myAnno0 = aTypes[0].getAnnotation(MyAnnotation.class);
 MyAnnotation myAnno1 = aTypes[1].getAnnotation(MyAnnotation.class);