String builderID = ... your builder id
IProject project = ... project

IProjectDescription description = project.getDescription();

ICommand[] oldBuildSpec = description.getBuildSpec();

// TODO check not already present

ICommand newCommand = description.newCommand();
newCommand.setBuilderName(builderID);

// Add a API build spec after all existing builders
ICommand[] newCommands = new ICommand[length + 1];
System.arraycopy(oldBuildSpec, 0, newCommands, 0, length);
newCommands[length] = newCommand;

// Commit the spec change into the project
description.setBuildSpec(newCommands);
project.setDescription(description, null);