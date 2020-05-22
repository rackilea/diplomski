// model/bean 
    public class AlbumManagerModel .. {
         // properties
         ObservableList<Album> albums;
         Album selectedAlbum;

         // vents the list of elements
         ObservableList<Album> getManagedAlbums() {
              return albums;
         }

         // getter/setter
         public Album getSelectedAlbum() {
              return selectedAlbum; 
         }

         public void setSelectedAlbum(Album album) {
            Album old = getSelectedAlbum();
            this.selectedAlbum = album;
            firePropertyChange("selectedAlbum", old, getSelectedAlbum());
         }


    }

    // bind the manager to a JTable

    BindingGroup context = new BindingGroup();
    // bind list selected element and elements to albumManagerModel
    JTableBinding tableBinding = SwingBindings.createJTableBinding(
            UpdateStrategy.READ,
            albumManagerModel.getManagedAlbums(), albumTable);
    context.addBinding(tableBinding);
    // bind selection 
    context.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            albumManagerModel, BeanProperty.create("selectedAlbum"), 
            albumTable, BeanProperty.create("selectedElement_IGNORE_ADJUSTING")
    ));
    // bind columns 
    tableBinding.addColumnBinding(BeanProperty.create("artist"));
    ...
    context.bind();