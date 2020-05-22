Camera newCamera = new OrthographicCamera(300, 200);
//... here is some other camera initialization code
newCamera.update();//recalculate camera matrices
stage.setCamera(newCamera);

//after that you may need to update sprite batch projection matrix

_gameStage.getSpriteBatch().setProjectionMatrix(newCamera.combined);