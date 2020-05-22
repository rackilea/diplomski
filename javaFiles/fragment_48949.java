private ConstantNode getConstantNode(NumericalValue value){
    ConstantNode node = Mockito.mock(ConstantNode.class);
    Mockito.when(node.evaluate()).thenReturn(value);

    String numberToString = value.toString();

    Mockito.when(node.toString()).thenReturn(numberToString);
    return node;
}