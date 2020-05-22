public class indexMult {
matrix mat = new matrix();


public void calc(int Ay, int Ax, int By, int Bx, int Dy, int Dx, int size){

    System.out.println(Ay +" "+ Ax +" "+ By +" "+ Bx +" "+ Dy +" "+ Dx +" "+ size);
    if(size==2){

        mat.D[Dy][Dx] = mat.A[Ay][Ax] * mat.B[By][Bx] + mat.A[Ay][Ax+1] * mat.B[By+1][Bx];
        mat.D[Dy+1][Dx] = mat.A[Ay+1][Ax] * mat.B[By][Bx] + mat.A[Ay+1][Ax+1] * mat.B[By+1][Bx];
        mat.D[Dy][Dx+1] = mat.A[Ay][Ax] * mat.B[By][Bx] + mat.A[Ay][Ax+1] * mat.B[By+1][Bx+1];
        mat.D[Dy+1][Dx+1] = mat.A[Ay+1][Ax] * mat.B[By][Bx+1] + mat.A[Ay+1][Ax+1] * mat.B[By+1][Bx];


    }else{

        size = size/2;  
        calc(Ay, Ax, By, Bx, Dy, Dx, size);
        calc(Ay, Ax+size, By, Bx+size, Dy, Dx+size, size);
        calc(Ay+size, Ax, By+size, Bx, Dy+size, Dx, size);
        calc(Ay+size, Ax+size, By+size, Bx+size, Dy+size, Dx+size, size);
    }
}