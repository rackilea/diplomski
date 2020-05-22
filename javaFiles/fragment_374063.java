HashMap<String, String> setParameters = new HashMap<String, String>();
//some code for adding parameters to the hashmap is here
IRunAndRenderTask task = engine.createRunAndRenderTask(design);
task.setParameterValues(setParameters);
EXCELRenderOption options = new EXCELRenderOption();
options.setOutputFormat("csv");
options.setOutputFileName("output\\myxls.csv");
task.setRenderOption(options);
task.run();
task.close();