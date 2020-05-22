//Assuming this method checks itself whether it is a quadtrilateral or parallelogram
public String classify()           //no static declaration
{
    if(this.isParallelogram()){    //apply the check on itself
        System.out.print("parallelogram");
        return "parallelogram";
    }
    else{
        System.out.print("quadrilateral");
        return "quadrilateral";
    }
}