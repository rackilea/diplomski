for (record : records)
{
    begin_transaction();
    insert();
    commit_transaction();
}