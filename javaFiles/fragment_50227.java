this.indexOfMethodsByFirstLineNumber=new TreeMap<Integer, List<Method>>((int)(1.7d*methods.size()));
for (Method method: methods)
{
    // Note: The -1 in this line stands to make the SortedMap work properly when searching for ranges.
    int firstLine=getLineNumberTable().getSourceLine(0)-1;
    List<Method> methodsInTheSameLine=indexOfMethodsByFirstLineNumber.get(firstLine);
    if (methodsInTheSameLine==null)
    {
        methodsInTheSameLine=new ArrayList<Method>();
        indexOfMethodsByFirstLineNumber.put(firstLine,methodsInTheSameLine);
    }
    methodsInTheSameLine.add(method);
}