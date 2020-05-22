public static void main(String args[])
{
    String[] route = new String[100];                  
    int[][]array = {{4,-2,3,6}
                    ,{9,10,-4,1}
                    ,{-1,2,1,4}
                    ,{0,3,7,-3}};
    String[] route2 = new String[100];                
    int max = recursionAlg(array,array.length-1,0,route);        
    int max2 = loopAlg(array,array.length-1,0,route2);
    System.out.println("The max food in the recursion solution is: "+max);
    System.out.println("and the route is: ");
    printRouteArray(route);
    System.out.println("The max food in the loop solution: "+max2);
    System.out.println("The route is: ");
    printRouteArray(route2);
}

public enum Dirs {START, FROM_LEFT, FROM_DOWN};

public static int loopAlg(int [][] arr,int x, int y, String[] route)
{

    int n=0;
    int[][]count = new int[arr.length][arr[0].length];
    Dirs[][] directions = new Dirs[arr.length][arr[0].length];
    List<String> path = new ArrayList<String>();

    for(int i = x; i>=0 ; i--)
    {
        for(int j = 0; j<arr[0].length; j++)
        {
            if (i==x && j==0) {count[i][j]=arr[i][j]; directions[i][j] = Dirs.START;}
            else if (i == x) { count[i][j]=count[i][j-1]+arr[i][j]; directions[i][j] = Dirs.FROM_LEFT;}
            else if (j == 0) { count[i][j]=count[i+1][j]+arr[i][j]; directions[i][j] = Dirs.FROM_DOWN;}
            else{
                if (count[i][j-1]>count[i+1][j]) {count[i][j]=count[i][j-1]+arr[i][j];directions[i][j] = Dirs.FROM_LEFT;}
                else { count[i][j]= count[i+1][j]+arr[i][j];directions[i][j] = Dirs.FROM_DOWN;}
            }
        }
    }
    int i=0, j=arr[0].length-1;
    while(directions[i][j]!= Dirs.START) {
        if(directions[i][j] == Dirs.FROM_LEFT) {
            path.add("Right");
            j--;
        }
        else {
            path.add("Up");
            i++;
        }
    }
    Collections.reverse(path);
    i=0;
    for(String part:path) {
        route[i] = part;
        i++;
    }

    return count[0][arr[0].length-1];
}