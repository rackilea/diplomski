public static void main(String[] args) {
    NodeList commandList = ... // get your XML from somewhere
    Map<string,Integer> vars = new HashMap<string,Integer>();
    for (Node node : commandList) {
        evaluate(node, vars);
    }
    // At this point, vars contains values of all variables assigned in commands
    // from the command list
}