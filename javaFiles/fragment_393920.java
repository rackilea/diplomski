public static void multichoose(int n,int k, String currentSolution /* NEW ARGUMENT */)
{
    // String[] result = null; /* UNNECESSARY */
    System.out.print("Calling multichoose with");
    System.out.println("  "+Integer.toString(n)+"  "+Integer.toString(k));
    if(n==1)
    {
        // multinomial_elements[result_iter]=multinomial_elements[result_iter]+Integer.toString(k)+"|";
        multinomial_elements[result_iter]=currentSolution+k+"|"; /* CHANGED */
        ++result_iter;
    }
    else
    {
        if(k==0)
        {
            // result=new String[1]; /* UNNECESSARY */
            // result[0]="0"; /* UNNECESSARY */
            for(int a=0;a<n;a++)
                // multinomial_elements[result_iter]=multinomial_elements[result_iter]+"0"+"|";
                currentSolution += "0|"; /* CHANGED */
            multinomial_elements[result_iter] = currentSolution; /* NEW */
            ++result_iter;   
        }
        else 
        {
            for(int firstindexval=k;firstindexval>=0;firstindexval--)
                //for(int iter=0;iter<=k-firstindexval;iter++) /* UNNECESSARY */ 
                //{ /* UNNECESSARY */
                    //if(iter+firstindexval==k){ /* UNNECESSARY */

                        //multinomial_elements[result_iter]=multinomial_elements[result_iter]+Integer.toString(firstindexval)+"|"; /* SEE CHANGE BELOW */

                        //multichoose(n-1,iter);
                        multichoose(n-1, k-firstindexval /* CHANGED */, currentSolution+firstindexval+"|" /* NEW ARGUMENT */); /* CHANGED */
                    //} /* UNNECESSARY */

                //} /* UNNECESSARY */

        }
    }

}