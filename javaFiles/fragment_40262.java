fun setUsersMapConverter(){
    GdxFIRDatabase.instance().setMapConverter(object : FirebaseMapConverter {
        override fun <T : Any?> convert(map: MutableMap<String, Any>, wantedType: Class<T>): T {
            val element = (map.get(map.keys.first())) as HashMap<String, String>
            return UserPOJO(element.get("displayName"), element.get("email")) as T
        }
        // Should be inversion of convert (needed only by GWT platform)
        override fun unConvert(`object`: Any): Map<String, Any>? {
            return null
        }
    })
}