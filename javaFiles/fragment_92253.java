else if (tkn.equals("^") || tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-")) {
    if (!ops.isEmpty() && !hasPrecedence(tkn, ops.peek())) {
        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        System.out.println("ADDING to values: " + values.peek());
    }
    else {
        // Push current token to 'ops'.
        ops.push(tkn);
        System.out.println("ADDING to ops: " + ops.peek());
    }
}