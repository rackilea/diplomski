public class ProjectLabelDecorator extends LabelProvider 
   implements ILightweightLabelDecorator {

   ...

   public void decorate(Object element, IDecoration decoration) {
      if (element instanceof IFolder) {
         IFolder folder = (IFolder) element;
     try {
            if (folder.getProject().hasNature("rttdt.nature")) {
                if (ProjectNature.isTestcase(folder)) {
                   IDecorationContext context = 
                      decoration.getDecorationContext();
                   if (context instanceof DecorationContext) {
                      ((DecorationContext) context).putProperty(
                         IDecoration.ENABLE_REPLACE, Boolean.TRUE);
                   }
                   decoration.addOverlay(fTestcaseOverlay,
                      IDecoration.REPLACE);
                }
         } catch (CoreException e) {
         }
      }
   }

   ...
}