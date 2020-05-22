// XML 1.1
// [#x1-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]
String xml11pattern = "[^"
                    + "\u0001-\uD7FF"
                    + "\uE000-\uFFFD"
                    + "\ud800\udc00-\udbff\udfff"
                    + "]+";