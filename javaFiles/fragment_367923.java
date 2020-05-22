JobProcess.withCriteria {
    scriptUser {
        like('firstName', "%${params.name}%")
    }
    maxResults(params.max as int)
    firstResult(params.offset ? params.offset.toInteger() : 0)
}