public static void printConfigApplied(Configuration conf) 
     try {
                conf.writeXml(System.out);
            } catch (final IOException e) {
                e.printStackTrace();
            }
}