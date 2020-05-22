String resDir = "/dss_core/HTML5/webapp";
String resurl = dss_core.util.DRYcode.platformIsAndroid()?"file:/mnt/sdcard/protected/"+servletName:
                DRYcodeWeb.class.getResource(resDir).toString();
if (dss_core.util.DRYcode.platformIsAndroid())
    for (String str:resourceList)
        DRYcode.copy_("/dss_core/HTML5/webapp/"+str,"/mnt/sdcard/protected/"+servletName+"/"+str);