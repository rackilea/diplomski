getNResults ordered by id (ascending)
while(shouldRetrieveMoreResults()) {
    memorize the last id in the list of retrieved results
    instead of skip, use the following query: "get 200 objects ordered by id  ascending where id > _a_memorized_id"
    memorize the last id among retrieved ids and perform the loop again and again
}