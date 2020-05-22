for (int iA = 0; iA < listA.size(); iA++) //iterate over listA
{
    ListElement currentElement = listA.get(iA);
    for (int iB = 0; iB < listB.size(); iB++) //iterate over listB
    {
        ListElement other = listB.get(iB); 
        if (other.index == currentElement.index) //compare the elements
        {
            //do stuff
            currentElement.setData(other.getData()); 
            break; //if only want first match
        }         
    }
}