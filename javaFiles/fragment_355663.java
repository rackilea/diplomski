static void nested(int depth, int index, ArrayList< ArrayList<Integer> > list, ArrayList<Integer> curr)
{

    if(depth==0)
    {


        ArrayList <Integer> x = new ArrayList<>();
        int i;
        for( i=0;i<curr.size();i++)
        {
            System.out.println(curr.get(i));

            x.add(curr.get(i));
        }
        global.add(x);

        //curr.remove(curr.size()-1);

    }
    else
    {

        for(int i=0;i<list.get(index).size();i++)
        {

            curr.add(list.get(index).get(i));

            nested(depth-1, index+1, list, curr);

            //if (curr.size()==list.get(index).size())
            //{
                curr.remove(curr.size()-1);
            //}

            //if(index==0 &&(curr.size()-1) == i)
            //    curr = new ArrayList<>();


        }
    }

}