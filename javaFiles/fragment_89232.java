@Override
public void earlyStartup()
{
  Display.getDefault().asyncExec(new Runnable() {
   @Override
   public void run() {
     final ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
     System.out.println("service " + service);
   }
 });
}