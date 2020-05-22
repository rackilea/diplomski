capacity as the total volume of water it can hold
storage as the total volume of water it currently holds
inflow as volume of water flowing into the dam per second
outflow as volume of water flowing out of the dam per second 

int flow_rate_difference = 0 ;
Long dam_fill_seconds = 0;
Long dam_empty_seconds = 0;

if(inflow > outflow)
{
     //we have to calculate the amount of seconds it will take to fill the dam
     // 1 acre foot = 43560.0004435. I am taking 43560 plz use full value if you require more accuracy 
     // conversion taken from http://www.convertunits.com/from/cubic+foot/to/acre+foot

     // total capacity 3538000acrefoot
     // current capacity = total capacity - stored capacity ie (3538000-1796250) acrefoot
     // current capacity in cubic foot  (3538000-1796250)*43560
     // at the same second water is flowing into and out of dam . but if inflow is higher then that difference we have to calculate

     flow_rate_difference = inflowRate - outflowRate;
     // total sec required to fill dam is current capacity / flow_rate_difference 
     dam_fill_seconds = (3538000-1796250)*43560/flow_rate_difference ;

}
if (outflow > inflow )
{
    //time for dam to be empty

     flow_rate_difference =  outflowRate-inflowRate;
     //here we just need to take stored capacity 

     dam_empty_seconds = storage*43560/flow_rate_difference;



}