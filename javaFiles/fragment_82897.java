String[] operands = text.substring(1, text.length()).split("[;()]+");
int numIfs = operands.length / 3; // actually (operands.length - 1) / 3 but int division makes it the same 
String[] nodes = new String[numIfs]; // stores the nodes (test strings)
int[] operandNos = new int[numIfs]; // stores the number of operands the if currently has
int nodesIndex = -1; // the index of the if node currently parsed
for (String s : operands) {
    if (s.equals("IF")) {
        // new if found -> increase position in the "stack" (nodes)
        operandNos[++nodesIndex] = 0;
    } else {
        addVertex(s);
        switch (operandNos[nodesIndex]++) {
            case 0:
                // first operand = node name
                nodes[nodesIndex] = s;
                break;
            case 1:
                // second operand found -> add edge
                addEdge(s, nodes[nodesIndex]);
                break;
            case 2:
                // last operand found -> add edge and go back
                do {
                    addEdge(s, nodes[nodesIndex]);
                    s = nodes[nodesIndex--];
                } while (nodesIndex >= 0 && operandNos[nodesIndex]++ == 2);
                if (nodesIndex >= 0) {
                    // was not the last operand of the IF
                    addEdge(s, nodes[nodesIndex]);
                }
        }
    }
}