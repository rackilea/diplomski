dataTable.getTable().setRedraw(false);  // Stop redraw during update

IStructuredSelection selection = (IStructuredSelection)dataTable.getSelection();

for (Iterator<?> iterator = selection.iterator(); iterator.hasNext(); )
 {
   Object selectedObject = iterator.next();

   // TODO remove from data model array

   // Tell table view the object has been removed

   dataTable.remove(selectedObject);
 }

dataTable.getTable().setRedraw(true);  // Allow updates to be drawn