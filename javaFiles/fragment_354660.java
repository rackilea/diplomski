File file = null;
if ((args == null) || (args.length == 0)) {
   file = parse.getFile("findAnAnimal.csv");
} else {
   System.out.println(args[0]);
}