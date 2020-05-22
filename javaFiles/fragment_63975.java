for(int i = 0; i<tbnImages.size(); i++){
        vf.addView(new CustomView(context,
                tbnImages.get(i),
                tbnNames.get(i),
                tbnDescripton.get(i),
                tbnDescs.get(i)));
    }