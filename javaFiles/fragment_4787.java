// Setup parameters:
ListParameterization params = new ListParameterization();
params.addParameter(FileBasedDatabaseConnection.INPUT_ID, filename);
// Add other parameters for the database here!

// Instantiate the database:
Database db = ClassGenericsUtil.parameterizeOrAbort(
    StaticArrayDatabase.class,
    params);
// Don't forget this, it will load the actual data...
db.initialize();

Relation<DoubleVector> vectors = db.getRelation(TypeUtil.DOUBLE_VECTOR_FIELD);
Relation<LabelList> labels = db.getRelation(TypeUtil.LABELLIST);