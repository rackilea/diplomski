import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;

public class CustomJavaArgumentsTab extends JavaArgumentsTab {

    @Override
    public void setDefaults(ILaunchConfigurationWorkingCopy config) {
        // start with the normal defaults for this tab...
        super.setDefaults(config);
        // ... then set/override them with what I want
        // ATTR_VM_ARGUMENTS is defaulted to null, provide my desired default
        config.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, "my desired default");
    }
}