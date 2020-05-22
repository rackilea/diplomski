for(int rad=100;rad<=500;rad+100)
{

    CircleOptions circleOptions = new CircleOptions()
              .center(latLng)   //set center
              .radius(rad)   //set radius in meters
              .fillColor(Color.TRANSPARENT)  //default
              .strokeColor(0x10000000)
              .strokeWidth(5);

              myCircle = googleMap.addCircle(circleOptions);
}