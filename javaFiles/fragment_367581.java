//Add and remove item when cell is reused for different item
            final ChangeListener<T> itemChangedEventHandler = (observable, oldValue, newValue) -> {
               synchronized (TrackingListCellFactory.this) {
                    if (oldValue != null) {
                        visibleItems.remove(oldValue);
                    }

                    if (newValue != null) {
                        visibleItems.add(newValue);
                        updateMessengerServiceControlModel(newValue, MessageStatus.MessageStatusEnum.SEEN);           
                    }                  
                }
            };

            //Update set when bounds of item change
            final ChangeListener<Object> boundsChangedHandler = (observable, oldValue, newValue) -> {
                synchronized (TrackingListCellFactory.this) {
                    T item = cell.getItem();                    

                    if (item != null) {
                        visibleItems.add(item);
                        updateMessengerServiceControlModel(item, MessageStatus.MessageStatusEnum.SEEN);
                    }                    
                }
            };

            cell.itemProperty().addListener(itemChangedEventHandler);

            //Must update either if cell changes bounds, or if cell moves within scene (e.g. by scrolling):
            cell.boundsInLocalProperty().addListener(boundsChangedHandler);
            cell.localToSceneTransformProperty().addListener(boundsChangedHandler); 

            return cell;