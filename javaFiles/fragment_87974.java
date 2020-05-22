public long returnRowCount (List<String> columnsAffected, Dataset<Row> dataset) {
    String str = "";

    for (String col : columnsAffected){
        if (str != "")
            str = str + String.format("or %1$s is null or %1$s == '' ", col);
        else
            str = String.format(" %1$s is null or %1$s == '' ", col);
    }
    return dataset.filter(str).count();
}