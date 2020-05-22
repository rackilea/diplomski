CTR ctr = myRun.getCTR(); // 
List<CTDrawing> images = ctr.getDrawingList();
for (int i=0; i<images.size(); i++)
{
    ctr.removeDrawing(i);
}