homeTeam = tokenizer.nextToken();
String temp = tokenizer.nextToken();
try
{
    homeScore = Integer.parseInt(temp);
}
catch(Exception e)
{
    //Comes here if temp is not an integer, so temp is second part of name
    homeTeam = homeTeam + " "+temp; 
    homeScore = Integer.parseInt(tokenizer.nextToken());
}
//Whatever the case, if we come here, it means both hometeam and score are assigned.
...........      
...........
...........