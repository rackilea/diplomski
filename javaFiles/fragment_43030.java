onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){

   if(fromUser){
    int x = progress + minValue;
    //snap progress to the nearest x_value
    int nearestX = getNearestXValue(x, x_value);
    seekbar.setProgress(nearestX);

    updateChartline(nearestX);
   }

}