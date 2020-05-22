package com.somewhere;

public class Utils {
    public static class DateUtils {
        public static Date today() {
            return new Date();
        }
    }

    public static class FilenameUtils {
        public static String stripExtension(String path) {
            return path.substring(0, path.lastIndexOf("."));
        }
    }
}