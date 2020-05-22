Pattern TAG_START     = Pattern.compile("</?[\\w-]+");
Pattern TAG_END       = Pattern.compile("/?>");
Pattern COMMENT_START = Pattern.compile("<!--");
Pattern COMMENT_END   = Pattern.compile("-->");
Pattern CDATA_START   = Pattern.compile("<\\[CDATA\\[");
Pattern CDATA_END     = Pattern.compile("\\]\\]>");