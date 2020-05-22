float a = 100;
float b = 100;

PolygonRegion polygonRegion=new PolygonRegion(textureRegion,new float[] {
            a*0, b*0,
            a*0, b*2,
            a*1, b*2,
            a*1.5f, b*1.5f,
            a*3, b*1.5f,
            a*3.5f, b*1,
            a*4, b*1,
            a*4.5f, b*1.5f,
            a*5f, b*1.5f,
            a*5f, b*0f},new short[] {
            0, 1, 2,1,2,3,0,2,3,0,3,4,0,4,5,0,5,6,0,6,9,6,7,9,7,8,9
 });

 PolyActor polyActor =new PolyActor(polygonRegion);
 polyActor.setPosition(75,0);
 stage.addActor(polyActor);