@Select("{call [dbo].[cai_Select](1)}")
@ResultMap("WResultMap")
@Options(
    statementType = StatementType.CALLABLE,
    resultSets = "firstRS,secondRS">
WQueryResult call();