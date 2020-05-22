GeometryInfo ginfo=new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
        Triangulator tr = new Triangulator();
        NormalGenerator normalGenerator = new NormalGenerator();
        Stripifier st = new Stripifier();  
        int [] iint=new int[]{4,4,4,4,4,4};-->each face of cube has 4 points
        ginfo.setStripCounts(iint);
        ginfo.setCoordinates(pts); 
        tr.triangulate(ginfo); // ginfo contains the geometry     
        normalGenerator.generateNormals( ginfo );
        st.stripify(ginfo);
        sh.setGeometry(ginfo.getGeometryArray()); // shape is a Shape3D.
        //now you can use Shape3D-type sh as a 3D-surface-containing shape