@Override
      public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (event.getAction()) {
        case DragEvent.ACTION_DRAG_STARTED:
        // do nothing
          break;
        case DragEvent.ACTION_DRAG_ENTERED:
            break;
        case DragEvent.ACTION_DRAG_EXITED:        

          break;
        case DragEvent.ACTION_DROP:
          // Dropped, reassign View to ViewGroup

          break;
        case DragEvent.ACTION_DRAG_ENDED:
         // option 1
          Context.stopService();
           // option 2
            // stopService(new Intent(Activity.this,MailService.class));
           //stopSelf();
            //  other alternative is
             //  v.getContext().stopService(new Intent(v.getContext(),DragDropButtonMainService.class));
          break;
        }
        return true;
      }