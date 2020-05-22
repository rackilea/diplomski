class CustomDialectResolver : DialectResolver {

    override fun resolveDialect(info: DialectResolutionInfo?): Dialect {
        return DB2zOSDialect()
    }
}