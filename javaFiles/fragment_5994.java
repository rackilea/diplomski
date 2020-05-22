TreeTargetDetails treeTargetDetails = 
    ((TreeTargetDetails) event.getTargetDetails());
MouseEventDetails mouseEventDetails =
    MouseEventDetails.deSerialize((String) treeTargetDetails.getData("mouseEvent"));

if (mouseEventDetails.isCtrlKey())
{
    ...
}