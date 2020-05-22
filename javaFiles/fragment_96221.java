import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IWorkbenchWindow;

private void addMavenNature( IProject project){
   IProjectDescription desc = project.getDescription();

   String[] prevNatures = desc.getNatureIds(); //it takes all previous natures of project i.e studioNature,javanature
   String[] newNatures = new String[prevNatures.length + 1];

   System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);

   newNatures[prevNatures.length] = "org.eclipse.m2e.core.maven2Nature"; //add maven nature to the project
   desc.setNatureIds(newNatures);

   project.setDescription(desc, new NullProgressMonitor());

   ICommand[] commands = desc.getBuildSpec();
   List<ICommand> commandList = Arrays.asList( commands );
   ICommand build = new BuildCommand();
   build.setBuilderName("org.eclipse.m2e.core.maven2Builder"); //add maven builder to the project
   List<ICommand> modList = new ArrayList<>( commandList );
   modList.add( build );
   desc.setBuildSpec( modList.toArray(new ICommand[]{}));
}