@Override
public Page<User> getUsers(Emisor pEmisor, int pPage, int pSize, Sort pSort, String pRSQLFilters) {

    Pageable pageable = new PageRequest(pPage, pSize, pSort);

    BooleanExpression filters = null;

    Node queryTree;
    try {
        logger.debug("Parsing query: {}", pRSQLFilters);
        queryTree = new RSQLParser().parse(pRSQLFilters);

        RsqlParserVisitor<BooleanExpression, QUser> rsqlParserVisitor = new RsqlParserVisitor<BooleanExpression, QUser>();
        filters = queryTree.accept(rsqlParserVisitor, QUser.user);

    } catch (TokenMgrError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (RSQLParserException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    Page<User> lista  = userRepository.findAll(filtros, pageable);

    return lista;

}