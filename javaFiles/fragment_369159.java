Pattern p = Pattern.compile("apple_orange_(\\w+)_banana\\d+[.]txt");
Map<String, Integer> map = new HashMap<>();

File dir = new File("d:/zzz");//path to directory containing your files
File[] files = dir.listFiles();//you can provide file filter here
Arrays.sort(files);//lets make sure that files are sort alphabetically

for (File f : files) {
    Matcher m = p.matcher(f.getName());
    if (m.find()) {
        String name = m.group(1);
        int counter = map.getOrDefault(name, 0) + 1;
        map.put(name, counter);
        f.renameTo(new File(dir, String.format("%s%02d.txt", name, counter)));
    }
}