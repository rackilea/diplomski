@Formula("(SELECT items.end_date from "
    + "subTable sub, "
    + "ItemTable items "
    + "WHERE items.sub_id = sub.sub_id "
    + "and header.header_id = sub.header_id "
    + "order by items.end_date desc "
    + "limit 1)")
private Date latestStartDate;

public getLatestStartDate() {
    return latestStartDate;
}