SparkSession spark = SparkSession
                .builder()
                .appName("appname")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

Dataset<Row> dfToModify = spark.read().table("TableToModify");

List<Row> ListListWithInfo = new ArrayList<>(Arrays.asList());

ListWithInfo.add(0,RowFactory.create("field1", "input1", "output1", "conditionAux1"));
ListWithInfo.add(1,RowFactory.create("field1", "input1", "output1", "conditionAux2"));
ListWithInfo.add(2,RowFactory.create("field1", "input2", "output3", "conditionAux3"));
ListWithInfo.add(3,RowFactory.create("field2", "input3", "output4", "conditionAux4"));
.
.
.
// initialize values for fields and conditions
String field_ant = ListWithInfo.get(0).getString(0).toLowerCase();
String first_input = ListWithInfo.get(0).getString(1);
String first_output = ListWithInfo.get(0).getString(2);
String first_conditionAux = ListWithInfo.get(0).getString(3);
Column whenColumn = when(dfToModify.col(field_ant).equalTo(first_input)
                .and(dfToModify.col("conditionAuxField").equalTo(lit(first_conditionAux)))
                ,first_output);

// lists with the names of the fields and the conditions        
List<Column> whenColumnList = new ArrayList(Arrays.asList());
List<String> fieldsNameList = new ArrayList(Arrays.asList());

for (Row row : ListWithInfo.subList(1,ListWithInfo.size())) {

            String field = row.getString(0);
            String input = row.getString(1);
            String output = row.getString(2);
            String conditionAux = row.getString(3);

           if (field.equals(field_ant)) {
                 // if field is equals to fiel_ant the new condition is added to the previous one
                whenColumn = whenColumn.when(dfToModify.col(field).equalTo(input)
                        .and(dfToModify.col("conditionAuxField").equalTo(lit(conditionAux)))
                        ,output);
            } else {
                // if field is diferent to the previous:
                // close the conditions for this field
                whenColumn = whenColumn.otherwise(dfToModify.col(field_ant));

                // add to the lists the field(String) and the conditions (columns)
                whenColumnList.add(whenColumn);
                fieldsNameList.add(field_ant);

                // and initialize the conditions for the new field
                whenColumn = when(dfToModify.col(field).equalTo(input)
                                .and(dfToModify.col("branchField").equalTo(lit(branch)))
                        ,output);
            }

            field_ant = field;

        }

// add last values
whenColumnList.add(whenColumn);
fieldsNameList.add(field_ant);

// transform list to Seq
Seq<Column> whenColumnSeq = JavaConversions.asScalaBuffer(whenColumnList).seq();
Seq<String> fieldsNameSeq = JavaConversions.asScalaBuffer(fieldsNameList).seq();

Dataset<Row>  dfModified = dfToModify.withColumns(fieldsNameSeq, whenColumnSeq);