desc.setNatureIds(new String[] {org.eclipse.jdt.core.JavaCore.NATURE_ID, "org.eclipse.wst.common.project.facet.core.nature"});
org.eclipse.core.resources.ICommand[] commands = new ICommand[] { desc.newCommand(), desc.newCommand };
commands[0].setBuilderName(org.eclipse.jdt.core.JavaCore.BUILDER_ID);
commands[1].setBuilderName("org.eclipse.wst.common.project.facet.core.builder");
desc.setBuildSpec(commands);

createProject(...) {
...
proj.create(description, ...);
IFolder srcFolder = proj.getFolder(new Path("src"));
srcFolder.create(false, true, new NullProgressMonitor());
org.eclipse.jdt.core.IJavaProject javaProject = org.eclipse.jdt.core.JavaCore.create(proj);
org.eclipse.jdt.core.IClasspathEntry src = JavaCore.newSourceEntry(srcFolder.getFullPath());
IClasspathEntry jre = JavaCore.newContainerEntry(new Path(org.eclipse.jdt.launching.JavaRuntime.JRE_CONTAINER), new IAccessRule[0], new IClasspathAttribute[] { JavaCore.newClasspathAttribute("owner.project.facets", "java")}, false);
IClasspathEntry[] entries = new IClasspathEntry[] { src, jre };
javaProject.setRawClasspath(entries, proj.getFullPath().append("bin"), new NullProgressMonitor());