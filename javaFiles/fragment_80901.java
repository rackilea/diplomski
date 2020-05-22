ArrayList<Photos> photos = new ArrayList<Photos>(); //Photos has an ImageView that can be set via constructor

callBackMethod(YoutubeThumbnailView source){
ImageView temp = new ImageView(this);  //initialize beforehand somewhere in the program
temp.setImageDrawable(source.getDrawable());
photos.add(new Photo(temp));      //or just do photos.add(new Photo(source)) directly
aMethodThatCallsThisMethodAgain();
}