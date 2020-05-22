CircleOptions circleOptions = new CircleOptions()
        .center(latlng)
        .radius(500)
        .strokeWidth(2)
        .strokeColor(Color.BLUE)
        .fillColor(Color.parseColor("#500084d3"));
        // Supported formats are: #RRGGBB #AARRGGBB
        //   #AA is the alpha, or amount of transparency

    mMap.addCircle(circleOptions);