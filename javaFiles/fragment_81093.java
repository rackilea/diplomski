struct Msg
{
   int msgType;
   double Val1;
   double Val2;
}; // assuming packing on 32-bit boundary

union
{
   Msg msg;
   unsigned char msgAsBinary[20];
};