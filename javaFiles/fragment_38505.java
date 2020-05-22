Moments p = new Moments();

        List<Moments> nu = new ArrayList<Moments>(contours.size());

        for(int i=0; i<contours.size(); i++)
        {
            nu.add(i, Imgproc.moments(contours.get(i),false));
             p=nu.get(i);

        }