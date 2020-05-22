final Pattern rx = Pattern.compile("AB"); // Matches names wich contain 'AB'

File baseDir = new File("C:\\Users\\myUser\\myArchive\\");
Predicate<String> nameMatcher = rx.asPredicate();

// this will result in a list of File
List<File> result = Arrays.stream(baseDir.listFiles())
    .filter(f->f.isDirectory())
    .filter(f->nameMatcher.test(f.getName()))
    .collect(Collectors.toList());

System.out.println(result); // [C:\Users\myUser\myArchive\ABC003PR, C:\Users\myUser\myArchive\TAB113]


// this will result in a list of String 
List<String> result2 = Arrays.stream(baseDir.listFiles())
        .filter(f->f.isDirectory())
        .map(File::getName)
        .filter(nameMatcher)
        .collect(Collectors.toList());
System.out.println(result2); // [ABC003PR, TAB113]