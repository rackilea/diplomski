boolean added = false;
 while(iter.hasNext()){
      inListObject = iter.next();
      if(object.getRow() < inListObject.getRow() ||
         object.getRow() == inListObject.getRow()) &&
         object.getCol() < inListObject.getCol() ){
          if( iter.hasPrevious() ){
              iter.previous();
              iter.add(object);
          } else {
              rowColSeq.addFirst( object );
          }
          undoStack.push(object);
          added = true;
          break;
      }
 }

 if( ! added ){
      rowColSeq.addLast(object);
      undoStack.push(object);
      added = true;
 }