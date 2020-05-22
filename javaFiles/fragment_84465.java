TableColumn albumArt = new TableColumn("Album Art");
    albumArt.setCellValueFactory(new PropertyValueFactory("album"));
    albumArt.setPrefWidth(200); 


    // SETTING THE CELL FACTORY FOR THE ALBUM ART                 
albumArt.setCellFactory(new Callback<TableColumn<Music,Album>,TableCell<Music,Album>>(){        
    @Override
    public TableCell<Music, Album> call(TableColumn<Music, Album> param) {                
        TableCell<Music, Album> cell = new TableCell<Music, Album>(){
            @Override
            public void updateItem(Album item, boolean empty) {                        
                if(item!=null){                            
                    HBox box= new HBox();
                    box.setSpacing(10) ;
                    VBox vbox = new VBox();
                    vbox.getChildren().add(new Label(item.getArtist()));
                    vbox.getChildren().add(new Label(item.getAlbum())); 

                    ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
                    imageview.setImage(new Image(MusicTable.class.getResource("img").toString()+"/"+item.getFilename())); 

                    box.getChildren().addAll(imageview,vbox); 
                    //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                    setGraphic(box);
                }
            }
        };
        System.out.println(cell.getIndex());               
        return cell;
    }

});