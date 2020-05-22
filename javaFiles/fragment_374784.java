public void map(LongWritable k, Text value, Context context) throws IOException, InterruptedException
{
    //Get the line
    //split the line to get ID seperate
    //word1 = A 
    //word2 = 30
                //Likewise for A ABC
                   //word1 = A 
                  //word2 = ABC
    context.write(word1, word2);
}