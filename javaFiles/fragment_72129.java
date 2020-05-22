List<HashMap<String, Object>> outlines = SimpleBookmark.getBookmark(reader);
HashMap<String, Object> entry = new HashMap<String, Object>();
entry.put("Title", "Hello");
entry.put("Action", "GoTo");
entry.put("Page", "4 Fit");
updateOutline(outlines, entry, 4);
stamper.setOutlines(outlines);