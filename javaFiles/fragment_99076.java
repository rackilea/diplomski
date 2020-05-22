File file = new File("C:\\Users\\Aaron\\Documents\\MinecraftForge\\forge\\mcp");
    for(File s : file.listFiles())
    {
        if(s.getName().equals("recompile.bat"))
        {
            DefaultExecutor executor = new DefaultExecutor();
            executor.setWorkingDirectory(file);
            CommandLine commandLine = new CommandLine(s.getAbsolutePath());

            try

        {
            executor.execute(commandLine);
        } catch (ExecuteException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}