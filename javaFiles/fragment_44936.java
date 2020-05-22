for (int i = 0; i < colList.size(); i++)
{
    int index = i ;
    colList.get(i).setCellValueFactory(cellData -> cellData.getValue().getTokens()[index]);
    // ...
}