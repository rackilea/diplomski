private static void evaluateEigenface(int M,int N,Matrix x,double[] average,double[] eigenvalues,Matrix eigenfaces){

        // x is (widthProcessedImage*heightProcessedImage)X(numberProcessedImages);

        Matrix w=new Matrix(M,N,0.0);

        for(int i=0;i<M;i++){
            average[i]=0;
            for(int j=0;j<N;j++){
                average[i]=average[i]+x.get(i,j);
            }
            average[i]=average[i]/((double)N);
            //System.out.println(average[i]);
        }


        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                w.set(i, j, x.get(i,j)-average[i]);
            }
        }

        Matrix auxMat=w.transpose().times(w); // =w'*w

        SingularValueDecomposition SVD =  new SingularValueDecomposition(auxMat);
        double[] mu = SVD.getSingularValues(); // Eigenvalues of w'w
        Matrix d=SVD.getU(); // LeftSingularVectors of w'w => Each column is an eigenvector
        Matrix e=w.times(d); // Eigenvector of ww'

        for(int i=0;i<N;i++)eigenvalues[i]=mu[i];

        double theNorm;
        double[] auxArray=new double[M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)auxArray[j]=e.get(j,i);
            theNorm=norma2(M,auxArray);
            for(int j=0;j<M;j++)eigenfaces.set(j,i, e.get(j, i)/theNorm); // eigenfaces are the normalized eigenvectors of ww'
        }

    }