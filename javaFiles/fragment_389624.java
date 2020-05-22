String str = "(-34.17141334413566, 148.1231689453125)," +
            "(-34.371148707267096, 149.0130615234375)," +
            "(-34.475366823896806, 147.919921875)";
str = str.replace("(", "");
String[] rows = StringUtils.split(str, "),");
double[][] doubles = new double[rows.length][StringUtils.split(rows[0], ", ").length];
for (int i = 0; i < rows.length; i++)
{
    String[] cols = StringUtils.split(rows[i], ", ");
    for (int j = 0; j < cols.length; j++)
    {
        cols[j] = cols[j].replace(")", "");
        doubles[i][j] = Double.parseDouble(cols[j]);
    }
}