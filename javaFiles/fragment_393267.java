int length = ...;//length of result, either min or max as mentioned above, see HINT
byte[] mixBytes = new byte[length]; 

int amountAudio = ListAudio.size(); //amount of tracks in your list aka 'N' 

int sum;
for(int index = 0; index < length; index++){
    sum = 0;
    for(byte[] source: ListAudio){
        //adding all byte into one big integer
        sum = sum + source[index]; //NOTE: watch for indexOutOfBoundsException
    }
    //afterward divide the big int through amount of Audio tracks in your list
    mixBytes[index] = (byte)(sum / amountAudio);
}