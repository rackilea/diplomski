//Other Code

//batch or Camera Matrix

testMatrix4 = batch.getProyectionMatrix().cpy()
                .scale(YOUR_PPM_X, YOUR_PPM_Y, 0);

shapeRenderer.setProjectionMatrix(testMatrix4);

//Other Code