RelativeLayout.LayoutParams progressParams = (RelativeLayout.LayoutParams)progressBar.getLayoutParams();
progressParams.width=finalWidth*2;
progressParams.height= 20;
progressParams.setMargins(finalWidth, 0, finalWidth, finalHeight);

progressBar.setLayoutParams(progressParams);