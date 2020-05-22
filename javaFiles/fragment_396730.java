class Utils {
    companion object {
        @JvmStatic fun values(item: GSAItem): Map<String, Any?> {
            return item.itemDescriptor.propertyNames.associate { it to item.getPropertyValue(it) }
        }
    }
}