...
while (true) {
   string commandSpecification = getUserCommandSpecification();
   Command cmd(commandSpecification);
   cmd.execute();
}
...