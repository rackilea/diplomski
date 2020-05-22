.
   .
   .
   case DragEvent.ACTION_DROP:
       .
       .
       .
       // view dragged item is being dropped on
       ImageView dropTarget = (ImageView) v;
       // view being dragged and dropped
       ImageView dropped = (ImageView) view;

       String tagDropTarget = (String)dropTarget.getTag(),
              tagDroppedImage = (String)dropped.getTag();

       if ((tagDropTarget != null) && (tagDropTarget.equals (tagDroppedImage)) {

            // yippie! correct!!
            // update the image in the target view to reflect the data being dropped

            dropTarget.setImageDrawable(dropped.getDrawable());
        } else {
            // oppps, wrong!!!!
            .
            .
        }
        break;