DropTarget dropTarget;
DropHandler dropHandler;

.
.
.

dropHandler = new DropHandler();
dropTarget = new DropTarget(pnlOne, DnDConstants.ACTION_MOVE, dropHandler, true);