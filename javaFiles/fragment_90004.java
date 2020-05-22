public class TowerApp
{
    static int nDisks = 3;
    static public LinkStack A = new LinkStack("A");
    static public LinkStack B = new LinkStack("B");
    static public LinkStack C = new LinkStack("C");


    static public void doTowers(int nDisks, LinkStack source, LinkStack temp, LinkStack dest)
    {
        if(nDisks <= 4)
            if ((nDisks % 2) == 0)
            {   
                displayStacks(source, temp, dest);
                nDisks = nDisks - 1;
                long dn = source.pop();
                temp.push(dn);
                System.out.println("Disk # "+dn+" moved from Tower "+source.getName() +" to Tower "+temp.getName());
                displayStacks(dest, source, temp);

                dn = source.pop();
                dest.push(dn);
                System.out.println("Disk # "+dn+" moved from Tower "+source.getName() +" to Tower "+dest.getName());

                doTowers(nDisks, temp, source, dest);
            } 
            else
            {
                displayStacks(source, dest, temp);
                nDisks = nDisks - 1;
                long dn =  source.pop();
                dest.push(dn);
                System.out.println("Disk # "+dn+" moved from Tower "+source.getName() +" to Tower "+dest.getName());
                displayStacks(temp, source, dest);
            }

        /*          else if (nDisks >= 5)
        {
            doTowers(nDisks - 2, source, temp, dest);
            temp.push(source.pop());
            doTowers(nDisks - 2, dest, source, temp);
            dest.push(source.pop());
            doTowers(nDisks - 1, temp, source, dest);
        }*/
    }
    static public void displayStacks(LinkStack source, LinkStack temp, LinkStack dest)
    {           
        long n = source.pop();
        temp.push(n);
        System.out.println("Disk #"+n+" moved from Tower "+source.getName() +" to Tower "+temp.getName());
        PrintStacks();
        n = source.pop();
        dest.push(n);
        System.out.println("Disk #"+n+" moved from Tower "+source.getName() +" to Tower "+dest.getName());
        PrintStacks();
        n= temp.pop();
        dest.push(n);
        System.out.println("Disk #"+n+" moved from Tower "+temp.getName() +" to Tower "+dest.getName());
        PrintStacks();
    }

    static public void PrintStacks()
    {
        A.displayStack("TowerA");
        B.displayStack("TowerB");
        C.displayStack("TowerC");
        System.out.println("");
    }

    public static void main(String[] args)
    {
        for (int i = nDisks; i >= 1; i--)
        {
            A.push(i);
        }
        PrintStacks();

        doTowers(nDisks, A, B, C);
    }
}