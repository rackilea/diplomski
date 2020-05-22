public Method getMethodByLine(int lineNumber)
{
    Set<Method> methodsInTheSameLine=this.indexOfMethodsByFirstLineNumber.headMap(lineNumber).lastKey();
    if (methodsInTheSameLine.size()==0)
    {
        // There are no methods method in that line: Absurd.
    }
    else if (methodsInTheSameLine.size()>1)
    {
        // There are more than one method in that line. Hardly probable, but possible.
    }
    else
    {
        // There is one method in that line:
        return methods.get(0);
    }
}