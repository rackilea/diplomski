Mat r = new Mat(2, 2, CvType.CV_32F);
r.put(0, 0, 0.707);
r.put(0, 1, -0.707);
r.put(1, 0, 0.707);
r.put(1, 1, 0.707);

Mat v = new Mat(1, 2, CvType.CV_32F);
double d1 = 1.00;
double d2 = 2.00;
v.put(0, 0, d1);
v.put(0, 1, d2);
Mat final_mat = new Mat();

Core.gemm(v,r,1,new Mat(),0,final_mat);

System.err.println(final_mat.dump());