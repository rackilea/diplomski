StringConsumer consumer = new StringConsumer(); //Or LongConsumer

Field a = consumer.getClass().getDeclaredField("a");
//typeOfA represents A<String, String>
ParameterizedType typeOfA = (ParameterizedType) GenericTypeReflector.getExactFieldType(a, consumer.getClass());

Type[] args =  typeOfA.getActualTypeArguments();
System.out.println(args[0]); //String
System.out.println(args[1]); //String

Field b = A.class.getDeclaredField("b");
//or if you need it dynamic ((Class)typeOfA.getRawType()).getDeclaredField("b")
//or GenericTypeReflector.erase(typeOfA).getDeclaredField("b")
//typeOfB represents B<String>
ParameterizedType typeOfB = (ParameterizedType) GenericTypeReflector.getExactFieldType(b, typeOfA);
System.out.println(typeOfB.getActualTypeArguments()[0]); //String again