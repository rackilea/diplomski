File inFile = null;
if (0 < args.length) {
   inFile = new File(args[0]);
} else {
   System.err.println("Invalid arguments count:" + args.length);
   System.exit();
}