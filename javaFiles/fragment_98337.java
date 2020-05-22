private static Integer evaluate(Node node, Map<string,Integer> vars) {
    if (node is an assignment) {
        String varName = ... // get variable name from node
        Node expr = ... // get the node representing expression being assigned
        Integer value = evaluate(expr, vars);
        vars.put(varName, value);
        return value;
    }
    if (node is a variable reference) {
        String varName = ... // get variable name from node
        return vars.get(varName);
    }
    if (node is an integer constant) {
        String constVal = ... // Get the representation from XML
        return Integer.decode(constVal);
    }
    if (node is a binary expression) {
        Node lhs = ... // Get the left-hand side expression from the node
        Node rhs = ... // Get the right-hand side expression from the node
        Integer lhsVal = evaluate(lhs, vars); 
        Integer rhsVal = evaluate(rhs, vars);
        if (operator is plus) {
            return new Integer(((int)lhsVal) + ((int)rhsVal));
        }
        if (operator is minus) {
            return new Integer(((int)lhsVal) - ((int)rhsVal));
        }
        if (operator is multiply) {
            return new Integer(((int)lhsVal) * ((int)rhsVal));
        }
        if (operator is divide) {
            return new Integer(((int)lhsVal) / ((int)rhsVal));
        }
        // ... and so on
    }
    // ... and so on
}