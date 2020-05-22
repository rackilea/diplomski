Set<File> audioFileSet = ConcurrentHashMap.newKeySet(ArrayOfFiles.length);

Set<String> ext = new HashSet<>(Arrays.asList("mp3", "mp4", ...));

ContentResolver contentResolver = context.getContentResolver();

Arrays.stream(ArrayOfFiles).parallel().forEach(file -> {
    String extension = ...;
    if (ext.contains(extension)) {
        String mime = contentResolver.getType(Uri.fromFile(file));
        ...
        audioFileSet.add(file);
    }
});

// If you want list:
List<File> list = new ArrayList<>(audioFileSet);