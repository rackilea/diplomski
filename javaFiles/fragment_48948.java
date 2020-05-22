private ConstantNode getConstantNode(NumericalValue value){
    ConstantNode node = Mockito.mock(ConstantNode.class);
    Mockito.when(node.evaluate()).thenReturn(value);
    Mockito.when(node.toString()).thenReturn(value.toString());
    return node;
}