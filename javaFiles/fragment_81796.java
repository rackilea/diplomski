Rect scanningArea = new Rect(viewfinderView.getLeft(), viewfinderView.getTop(), viewfinderView.getRight(), viewfinderView.getBottom());
if(latestResult.iterator().hasNext())
        {

            boolean isInside = true;
            ArrayList<PointF> barcodelocation = latestResult.iterator().next().barcodeLocation;
            for (int i = 0; i < barcodelocation.size(); i++) 
            {
                int x = (int) barcodelocation.get(i).x;
                int y = (int) barcodelocation.get(i).y;
                if (!scanningArea.contains(x, y)) 
                {
                    isInside = false;
                }
            }
            if (isInside) 
            {
            //do stuff here
             }

        }