class GenericDAOImpl[T] {
var genericSuperclass: Type = null
var parametrizedClass: Class[_] = getClass()
do {
    genericSuperclass = parametrizedClass.getGenericSuperclass()
    if (genericSuperclass.isInstanceOf[Class])
        parametrizedClass = genericSuperclass.asInstanceOf[Class[_]]
} while (genericSuperclass != null
                && !(genericSuperclass.isInstanceOf[ParameterizedType]))
val entityClass = genericSuperclass.asInstanceOf[ParameterizedType]
                .getActualTypeArguments()(0).asInstanceOf[Class[T]]
val entityClassName =
  if (entityClass != null) 
      entityClass.getSimpleName()
  else
      null