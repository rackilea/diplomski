String key = request.getParameter("key");
List<FileItem> fileFields = (List<FileItem>) getServletContext().getAttribute(key);

if (fileFields == null) {
    fileFields = new ArrayList<FileItem>();
    getServletContext().setAttribute(key, fileFields);
}

fileFields.add(fileField);