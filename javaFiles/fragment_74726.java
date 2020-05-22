List<String> args = new ArrayList<String>
args.add("C:\\wamp\\bin\\mysql\\mysql5.5.24\\bin\\mysqldump.exe");
//...
args.add("-u");
args.add(getSourceUsername());
args.add("-p" + getSourceServerPassword()); //?? Is this a single command?
args.add("--add-drop-database");
args.add("-B");
args.add(getSourceDatabase());
args.add("-r");
args.add("path);
//...