import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.internal.adaptor.EclipseEnvironmentInfo;
import org.eclipse.ui.IStartup;

import test.Activator;

public class Test implements IStartup {

 @Override
 public void earlyStartup() {
  String message = "Arguments: " + Arrays.toString(EclipseEnvironmentInfo.getDefault().getCommandLineArgs());
  Activator.getDefault().getLog().log(new Status(IStatus.INFO, "Test", message));
 }

}