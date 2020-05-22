union convertor{
long input;
uint8_t output[4];
}

convertor entry;
entry.input=new Date().getTime()
//the value will be split into 4 unit8_t of entry.output