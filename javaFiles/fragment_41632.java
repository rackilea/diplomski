// methods containing the udf logic 
public static class MyUdf1 {
        public Integer eval(String a) {
            return a.length();
        }
    }


@Test
    public void test1() throws SQLException, ClassNotFoundException {

        CalciteConnection connection = MyTests.getCalciteConnection();

        final String functionName = "STR_LEN";
        final ScalarFunction udfLengthFunction = ScalarFunctionImpl.create(Types.lookupMethod(MyUdf1.class, "eval", String.class));
        connection.getRootSchema().getSubSchema("SYSTEM").add(functionName, udfLengthFunction);

        FrameworkConfig frameworkConfig = Frameworks.newConfigBuilder()
                .parserConfig(SqlParser.Config.DEFAULT)
                .defaultSchema(connection.getRootSchema().getSubSchema("SYSTEM"))
                .programs(Programs.sequence(Programs.ofRules(Programs.RULE_SET), Programs.CALC_PROGRAM))
                .build();

        SqlIdentifier udfLengthIdentifier = new SqlIdentifier(Collections.singletonList(functionName), null, SqlParserPos.ZERO, null);
        final SqlOperator strLenOperator = new SqlUserDefinedFunction(udfLengthIdentifier, ReturnTypes.INTEGER, null, OperandTypes.STRING, null, udfLengthFunction);

        final RelBuilder builder = RelBuilder.create(frameworkConfig);
        RelNode udfRelNode = builder
                .scan("EMP")
                .project(builder.call(strLenOperator, builder.literal("SampleString")))
                .build();

        ResultSet set = RelRunners.run(udfRelNode).executeQuery();
        set.next();
        System.out.println(set.getString(1));
    }