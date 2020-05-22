camera = new OrthographicCamera();
    if(screenHeight>1300)
    {

        Constants.WORLD_WIDTH=1280;
        Constants.WORLD_HEIGHT=960;

    }
    else{
        Constants.WORLD_WIDTH=1280;
        Constants.WORLD_HEIGHT=800;

    }
     viewPort = new FillViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera);
     viewPort.apply();