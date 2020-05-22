android.applicationVariants.all { variant ->
    def applicationId = variant.applicationId
    def adb = android.getAdbExe().toString()
    def variantName = variant.name.capitalize()
    def grantPermissionTask = tasks.create("create${variantName}Permissions") << {
        println "Granting permissions"
        "${adb} shell pm grant ${applicationId} android.permission.ACCESS_FINE_LOCATION".execute()
        "${adb} shell pm grant ${applicationId} android.permission.WRITE_EXTERNAL_STORAGE".execute()
        "${adb} shell pm grant ${applicationId} android.permission.READ_EXTERNAL_STORAGE".execute()
    }
}