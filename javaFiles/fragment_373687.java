You can try with below example:

    Iterator<Table> iterator=tableList.iterator();
    boolean foundConcept=false;
    while(iterator.hasNext())
    {
        foundConcept=false;
    Table table=iterator.next();
    String conceptName=table.getConceptDetails().getName();
    Field fieldArr[]=Table.getClass().getDeclaredFields();
    List<Field> fields=Arrays.asList(fieldArr);
     Iterator<Field> iterator1 =fields.iterator();
    int i=0;
    while(iterator1.hasNext())
    {
    Field field=iterator1.next();
    field.setAccessible(true);
    System.out.println(field.getName()+"  @   "+field.getType());
    if(field.getName().equalsIgnoreCase(conceptName) &&     String.class.isAssignableFrom(field.getType()))
    {
    foundConceptMap.put(conceptName, (field.get(Table)).toString());
    foundConcept=true;
    break;
    }
    else
       {
       Type type = field.getGenericType();
    if (type instanceof ParameterizedType) {
    ParameterizedType pType = (ParameterizedType)type;
    System.out.print("Raw type: " + pType.getRawType() + " - ");
    System.out.println("Type args: " + pType.getActualTypeArguments()[0]);
    if("java.util.List".equalsIgnoreCase(pType.getRawType().getTypeName()))
    {
        String classWithPackage=pType.getActualTypeArguments()[0].getTypeName();
        String className="";
        if(classWithPackage.contains("."))
        {
            className=classWithPackage.substring(classWithPackage.lastIndexOf(".")+1);
        }
        else
        {
        className=classWithPackage;
        }
        System.out.println(className);

        if("Terms".equalsIgnoreCase(className))
        {
            List<Terms> list=Table.getTerms();
            setTerms(list, foundConceptMap, conceptName);
        }
    }
    }
    }