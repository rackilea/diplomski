@PostFilter("hasRole('ROLE_ADMIN') or filterObject.ownerId == authentication.name")
public List<Record> finAllRecords() {

    // perform query to get all records.

}