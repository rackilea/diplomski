// Please use this form rather than putting the brackets after the name
// - it keeps all the type information together.
Object[][][] sqlQuery = null; // No point giving it a dummy value

List<Object[][]> list = new ArrayList<Object[][]>();
...
sqlQuery = list.toArray(new Object[0][][]);