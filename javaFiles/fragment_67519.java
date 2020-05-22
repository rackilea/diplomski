Object result = remoteobject.call("predictedResults", inputWords );
System.out.println("result = " + result);

ArrayList<Object[]> resultList = (ArrayList<Object[]>) result;
for (Object element : resultList) {
    Object[] pair = (Object[]) element;
    System.out.println((String)pair[0] + ", " + (Double)pair[1]); 
}