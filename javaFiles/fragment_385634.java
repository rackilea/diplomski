try {
    mp.setDataSource(titles[count]);
    count++;
    mp.prepare(); 
    mp.start();
}
catch(IOException e) {
    // Do something when MediaPlayer fails
}