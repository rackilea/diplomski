public static void main(String[] args) {
    String[][][] rubik={
            {
                {"red","red","red"},
                {"red","red","red"},
                {"red","red","red"}
            },{             
                {"blue","blue","blue"},
                {"blue","blue","blue"},
                {"blue","blue","blue"}
            },{
                {"yellow","yellow","yellow"},
                {"yellow","yellow","yellow"},
                {"yellow","yellow","yellow"}
            },{
                {"green","green","green"},
                {"green","green","green"},
                {"green","green","green"}
            },{
                {"orange","orange","orange"},
                {"orange","orange","orange"},
                {"orange","orange","orange"}
            },{
                {"white","white","white"},
                {"white","white","white"},
                {"white","white","white"}
            }
    };

    output(rubik, 0);
    output(rubik, 1);
    output(rubik, 2);
    output(rubik, 3);
    output(rubik, 4);
    output(rubik, 5);
}

public static void output(String[][][] rubik, int num)
{
    int i,j;
    int x = 0;
    System.out.println("Side: "+num);

    for(i = 0; i < 3; i++)
    {
        for(j = 0; j < 3; j++)
        {
            System.out.print(rubik[num][i][j]+"\t");
            x++;
        }
        System.out.println();

    }

    System.out.println();
    System.out.println();

}