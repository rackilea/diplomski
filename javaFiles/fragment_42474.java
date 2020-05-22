Map<BlogKey, Blog> map = new HashMap<BlogKey, Blog>();
for (Blog blog : blogs) {
     BlogKey key = createKey(blog);
     if (!map.containsKey(key)) {
          map.put(key, blog);
     }
}
Collection<Blog> uniqueBlogs = map.values();