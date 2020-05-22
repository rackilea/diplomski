final Task<ArrayList<Image>> task = new Task<ArrayList<Image>>() {
            @Override protected ArrayList<Image> call() throws Exception {

                int id = Data_model.getInstance().currentid();

                All_photos photos = (All_photos) new parse_object <All_photos> (All_photos.class).ParseUri("https://api.edmunds.com/api/media/v2/styles/"+id+"/photos?api_key=id&fmt=json");

                ArrayList<String> list_href = new SlideShowHelper().get_href(photos);

                ArrayList<Image> list = new ArrayList<Image>();

                int i = 1;

                            for ( String st:list_href)
                            {

                                System.out.println(st);
                                list.add(new Image("https://media.ed.edmunds-media.com"+st+"",true));
                                updateProgress(i, list_href.size());
                                Thread.sleep(400);
                                i++;


                            }
                            return list;
            }


             @Override protected void succeeded() {

                 super.succeeded();

                 updateProgress(10, 10);

                 img_slideshow.setImage(Images.get(0));

                 int count1 =count+1;

                 lbl_slideshow.setText(""+count1+" / "+Images.size()+"");

                 progress_sd.setVisible(false);  

                 btn_sd_back.setVisible(true);
                 btn_sd_next.setVisible(true);


             }


         };

        task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,new EventHandler<WorkerStateEvent>() {

            public void handle(WorkerStateEvent t) {
                Images = task.getValue();

            }
        });

    new Thread(task).start();


    //progress_sd.visibleProperty().bind(task.runningProperty());

    progress_sd.progressProperty().bind(task.progressProperty());

}