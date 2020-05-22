public void doSomething(java.lang.Object[] array) throws java.lang.Exception;
     0  aload_1 [array]
     1  invokevirtual java.lang.Object.getClass() : java.lang.Class [21]
     4  astore_2 [arrayClass]
     5  aload_2 [arrayClass]
     6  invokevirtual java.lang.Class.getComponentType() : java.lang.Class [25]
     9  astore_3 [componentType]
    10  aload_3 [componentType]
    11  invokevirtual java.lang.Class.newInstance() : java.lang.Object [30]
    14  astore 4 [newInstance]
    16  return