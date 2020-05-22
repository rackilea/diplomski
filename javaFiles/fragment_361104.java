bool should_shade(x,y,size_x,size_y) 
//sizes are size of small box and position x,y count from 0
{
     return ( (x/size_x + y/size_y ) % 2) == 0; //division is integer division

}