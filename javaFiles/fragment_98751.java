public static void draw(int w){
    draw(w, 0);
}

public static void draw(int W, int s){
    stars(W, s);
    if (W > 2) {
        draw(W-2, s+1);
        stars(W, s);
    }
}
public static void stars(int n, int s){
    if(s > 0){
        System.out.print(" ");
        stars(n, s-1);
    } else  if (n > 0){
        System.out.print("*");
        stars(n-1, s);
    } else {
        System.out.println();
    }
}