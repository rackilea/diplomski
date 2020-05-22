String command = "LIST BLAH";
UniSubroutine sub = uniSession.subroutine("RUN.COMMAND", 2);
sub.setArg(0, command);
sub.call();
UniDynArray response = new UniDynArray(sub.getArg(1));

for (int i = 0; i < response.dcount(); i++) {
    String line = response.extract(i).toString();
    System.out.println(line);
}