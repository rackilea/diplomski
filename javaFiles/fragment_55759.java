String[] urls = { 
  "http://localhost:8080/folder1/folder22/file.jpg", 
  "http://domain.com/folder1/folder22/file.jpg",
  "http://127.0.0.0.1:8080/folder1/folder22/file.jpg" };
for (String url : urls)
  System.out.println(new File(new URL(url).getPath()).getParent());