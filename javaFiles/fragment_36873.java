String input = "create table temp_username_current_timestamp other params"
String precedes = "table";
String extracted;

//Get the index of the start of the word to extract
int startIndex = input.indexOf(precedes) + precedes.length;
//Check if the word we are looking for is even there
if(startIndex > -1){
    //Get the index of the next space character
    int endIndex = input.indexOf(" ", startIndex);

    //If there are more parameters following ignore them
    if(endIndex > -1){
        //Extract the parameter given the indexes found
        extracted = input.substring(startIndex, endIndex);  
    } else {
        //If we are at the end of the string just extract what remains
        extracted = input.substring(startIndex);
    }
}