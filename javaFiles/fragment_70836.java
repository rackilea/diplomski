File[] files = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()).
    listFiles(new FileFilter() {
        public boolean accept(File pathname) {
            String name = pathname.getName();
            return pathname.isFile() && name.toLowerCase().startsWith("capture") && name.toLowerCase().endsWith(".jpeg");
        }
});

Arrays.sort(files);
File last = files[files.length - 1];

Pattern pattern = Pattern.compile("[0-9]+");
Matcher matcher = pattern.matcher(last.getName());

int index = 1;
if (matcher.find()) {
    String match = matcher.group();
    index = Integer.parseInt(match) + 1;
}

String fileName = "capture" + index + ".jpeg"