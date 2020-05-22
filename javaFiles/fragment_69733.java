Add if statement in end as shown in bold in code below.

public static void main(String args[])
           {
            lib1 o=new lib1();
            Scanner in=new Scanner(System.in);
            Scanner sc=new Scanner(System.in);
            int u[]={51,52,53,54,55};
            int p[]={1,2,3,4,5};
            int d=0;
            System.out.println("enter username and password");
            int un=in.nextInt();
            int pw=in.nextInt();

            for(int i=0,j=0;i<5 && j<5;i++,j++)
            {
                if(un==u[i] && pw==p[j])
                {
                    while(d==0)
                    {
                        System.out.println("enter subject name");
                        String c=sc.nextLine(); 
                        if(c.equals("java"))
                        o.java();
                        else if(c.equals("exit"))
                        {
                            d++;
                        }
                    }
                }   
            }
            **if(d == 0) {
                System.out.println("invalid password");
            }**
        }