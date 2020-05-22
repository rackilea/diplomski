List<String> files = new ArrayList<String>();
files.add("F:/some dir/");
files.add("F:\\some dir\\some.other.directory.with.full.stops.in.it");
files.add("F:\\some dir\\some.other.directory.with.full.stops.in.it\\");
files.add("F:/some dir/some.other.directory.with.full.stops.in.it");
files.add("F:/some dir/some.other.directory.with.full.stops.in.it/");

files.add("F:\\some dir\\some.other.directory.with.full.stops.in.it\\sub directory");
files.add("F:\\some dir\\some.other.directory.with.full.stops.in.it\\sub directory\\");
files.add("F:/some dir/some.other.directory.with.full.stops.in.it/sub directory");
files.add("F:/some dir/some.other.directory.with.full.stops.in.it/sub directory//");

for(String filePath : files)
{
    File file = new File(filePath);
    System.out.println("===== " + filePath + " ===== ");
    System.out.println("IsDirectory = " + file.isDirectory());
    System.out.println("IsFile = " + file.isFile());
}