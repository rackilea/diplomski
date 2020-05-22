myfirstpackage.ejb3.TriggerManually triggerManually;
try {
    InitialContext ctx = new InitialContext(props);
    triggerManually = (myfirstpackage.ejb3.TriggerManually) ctx.lookup("myjdniname");
    triggerManually.resetTasks();

} catch (NamingException e) {
    e.printStackTrace();
}