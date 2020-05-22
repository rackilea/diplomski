//assumptions
//#1 project  is [0] in workspace
//#2 compiler is [2] in workspace

//get project
IProject proj = ResourcesPlugin.getWorkspace().getRoot().getProject("hello_world");

//get <storageModule moduleId="org.eclipse.cdt.core.settings">
IManagedBuildInfo info = ManagedBuildManager.getBuildInfo(proj);

//get <storageModule moduleId="cdtBuildSystem">
IManagedProject sub_info = info.getManagedProject();

//get <configuration name="Debug">
IConfiguration config = sub_info.getConfigurations()[0];

//get <toolChain>
IToolChain toolchain = config.getToolChain();

//get <tool name="GCC C Compiler">
ITool tool = toolchain.getTools()[2];

//-----update command----//
ManagedBuildManager.setToolCommand(config, tool, "my_gcc");
ManagedBuildManager.saveBuildInfo(proj, true);