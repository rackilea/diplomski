public class Main {

static double min_d = 1e+10;

// diagonal distance factor cos(45), needs to multiply with hypotenuse 
static double c = 0.707110678; 

static double xt = 7.0;
static double yt = 17.0;

public static void solve(int time, double x, double y, double dirX, double dirY) {

    double d = Math.sqrt(Math.pow((x - xt), 2) + Math.pow((y - yt), 2));
    if( d < min_d )
        min_d = d;

    if( time == 0 || (d-time * 10) >= min_d ){
        return;
    }

    solve(time - 1, x + dirX, y + dirY, dirX, dirY);
    solve(time - 1, x, y, c * (dirX - dirY), c * (dirX + dirY));
}

public static void main(String[] args) 
{

    solve(9, 0.0, 0.0, 10.0, 0.0);
}

}// Class END