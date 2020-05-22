public class RsqlParserVisitor<BooleanExpression, A> implements RSQLVisitor<BooleanExpression, EntityPathBase<?>> {
...
    @Override
    public BooleanExpression visit(OrNode node, EntityPathBase<?> param) {
        // TODO Auto-generated method stub

        String nombreTmp = "OrNode";
        printLogicalNode(nombreTmp, node, param);

        return null;
    }

    @Override
    public BooleanExpression visit(EqualNode node, EntityPathBase<?> param) {
        // TODO Auto-generated method stub

        String nombreTmp = "EqualNode";
        printComparisonNode(nombreTmp, node, param);

        return null;
    }

...

    public void printLogicalNode(String pNombreNodo, LogicalNode pNode,
            EntityPathBase<?> pParam) {
        logger.debug(pNombreNodo + ". node: " + pNode + ". param: " + pParam);

        logger.debug("operator: " + pNode.getOperator().name());

        for (Node subNode : pNode) {
            logger.debug(pNombreNodo + ". subNode: " + subNode);
            subNode.accept(this, pParam);    <=========== this was the key to be able to traverse every node
        }
    }

    public void printComparisonNode(String pNombreNodo, ComparisonNode pNode,
            EntityPathBase<?> pParam) {
        logger.debug(pNombreNodo + ". node: " + pNode + ". param: " + pParam);

        logger.debug("Selector: " + pNode.getSelector());
        logger.debug("operator: " + pNode.getOperator());

        for (String argTmp : pNode.getArguments()) {
            logger.debug(pNombreNodo + ". argTmp: " + argTmp);
        }

    }

}