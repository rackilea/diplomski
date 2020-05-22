int n[]={1,2,4,5,6,10};
int len=n.length-1;
String startRange = "";
String endRange = "";

for (int k = 0; k<=len;k++)
        {
            startRange = String.valueOf(n[k]);

            for (int l = k; l<len;l++)
            {
                if (n[l+1]-n[l]!=1)
                {
                    endRange = String.valueOf(n[l]);
                    k=l;
                    break;
                }
                if (l==len-1)
                {
                    endRange = String.valueOf(n[l+1]);
                    k=l+1;
                    break;
                }
            }
            if (k==len)
            {
                endRange = String.valueOf(n[k]);
            }
            System.out.println("Range :: " + startRange + "," + endRange);              
        }