package name.seller.rich.classwizard.actions;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.actions.SelectionConverter;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class GenerateClassHandler extends AbstractHandler {

    public GenerateClassHandler() {
    }

    public Object execute(ExecutionEvent event) throws ExecutionException {
        NewClassWizardPage page = new NewClassWizardPage();

        EvaluationContext evaluationContext = (EvaluationContext) event
                .getApplicationContext();

        IWorkbenchPart activePart = (IWorkbenchPart) evaluationContext
                .getVariable("activePart");
        try {
            IStructuredSelection selection = SelectionConverter
                    .getStructuredSelection(activePart);

            IType type = getFirstType(selection);

            if (type != null && type.exists() && type.isInterface()) {
                page.init(selection);

                String typeName = type.getElementName() + "Impl";
                // TODO handle existing type
                page.setTypeName(typeName, true);

                // generate constructors and methods, allow modification
                page.setMethodStubSelection(false, true, true, true);

                page.setSuperInterfaces(Collections.singletonList(type
                        .getFullyQualifiedName()), true);
                try {
                    page.createType(new NullProgressMonitor());

                    IResource resource = page.getModifiedResource();
                    if (resource != null) {
                        IWorkbenchWindow window = HandlerUtil
                                .getActiveWorkbenchWindowChecked(event);
                        BasicNewResourceWizard
                                .selectAndReveal(resource, window);
                        openResource((IFile) resource, window);
                    }
                } catch (CoreException e) {
                    // TODO if we get this the type already exists, open a
                    // dialogue to allow the type name to be modified or give
                    // up?
                    logException(e);
                }

            }
        } catch (JavaModelException e) {
            logException(e);
        } catch (InterruptedException e) {
            logException(e);
        }
        return null;
    }

    protected void openResource(final IFile resource, 
            IWorkbenchWindow window) {
        final IWorkbenchPage activePage = window.getActivePage();
        if (activePage != null) {
            final Display display = window.getShell().getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
                    public void run() {
                        try {
                            IDE.openEditor(activePage, resource, true);
                        } catch (PartInitException e) {
                            logException(e);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void setEnabled(Object context) {
        if (context != null && context instanceof EvaluationContext) {
            EvaluationContext evaluationContext = (EvaluationContext) context;

            IWorkbenchPart activePart = (IWorkbenchPart) evaluationContext
                    .getVariable("activePart");

            try {
                IStructuredSelection selection = SelectionConverter
                        .getStructuredSelection(activePart);

                IType type = getFirstType(selection);

                if (type != null) {
                    setBaseEnabled(type.isInterface());
                    return;
                }
            } catch (JavaModelException e) {
                logException(e);
            }
        }

        setBaseEnabled(false);
    }

    private IType getFirstType(IStructuredSelection selection) {
        IJavaElement[] elements = SelectionConverter.getElements(selection);

        if (elements != null && elements.length > 0) {
            if (elements[0] != null && elements[0] instanceof IType) {
                return (IType) elements[0];
            }

            try {
                if (elements[0] != null
                        && elements[0] instanceof ICompilationUnit) {
                    IType[] types = ((ICompilationUnit) elements[0])
                            .getAllTypes();

                    if (types != null && types.length > 0) {
                        return types[0];
                    }
                }
            } catch (JavaModelException e) {
                logException(e);
            }
        }
        return null;
    }

    protected void logException(Exception e) {
        JavaPlugin.log(e);
    }
}