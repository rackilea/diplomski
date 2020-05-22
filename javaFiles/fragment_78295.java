--- Makefile.am 2014-08-28 09:57:37.000000000 -0700
+++ Makefile.am.patched 2014-08-28 09:57:20.000000000 -0700
@@ -1,5 +1,5 @@
 lib_LTLIBRARIES = libjpeg.la
-libjpeg_la_LDFLAGS = -version-info ${LIBTOOL_CURRENT}:${SO_MINOR_VERSION}:${SO_AGE} -no-undefined
+libjpeg_la_LDFLAGS = -avoid-version -no-undefined
 include_HEADERS = jerror.h jmorecfg.h jpeglib.h

 if WITH_TURBOJPEG