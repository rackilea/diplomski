class CatchNameExpr extends VoidVisitorAdapter {
    HashMap<String, ArrayList<Integer>> variableLineNumMap;``
    ArrayList<String> variableList;
    boolean functionParsing = false;
    public CatchNameExpr(ArrayList<String> classVariables) {
        variableList=classVariables;
    }
    public void visit(MethodDeclaration method, Object arg) {
        System.out.println("---------------");
        System.out.println(method.getName());
        System.out.println("---------------");
        variableLineNumMap = new HashMap<String, ArrayList<Integer>>();
        System.out.println();
        functionParsing = true;
        visit(method.getBody(),arg);
        // Analyze lines for variable usage. Add to list of vars after checking if its read or written or unknown.

        functionParsing = false;
    }

    public void visit(NameExpr n, Object arg) {

        if(!functionParsing)
            return;
        //TODO: check if this var was declared above it, as a local var to the func. if yes, return
        ArrayList<Integer> setOfLineNum;

        System.out.println(n.getBeginLine()+" NameExpr " + n.getName());

        if(!variableList.contains(n.getName()) || n.getName().length()==0)
            return;
        if (!variableLineNumMap.containsKey(n.getName()))
        {
            setOfLineNum =   new ArrayList<Integer>();
            setOfLineNum.add(n.getBeginLine());
            variableLineNumMap.put(n.getName(), setOfLineNum);
        }
        else
        {
            setOfLineNum = variableLineNumMap.get(n.getName());
            setOfLineNum.add(n.getBeginLine());
            variableLineNumMap.put(n.getName(), setOfLineNum);

        }
    }
}