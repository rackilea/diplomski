String merge = "";
public void reduce(Text key, Iterable<Text> values, Context context)
{
    int i =0;
    for(Text value:values)
    {
        if(i == 0){
            merge = value.toString()+",";
        }
        else{
            merge += value.toString();
        }
        i++;
    }
    valEmit.set(merge);
    context.write(key, valEmit);
}