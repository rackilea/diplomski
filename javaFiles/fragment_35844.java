for (int i = 0; i<peopleArray.size(); i++)
{
    for (int j = 0; j<peopleArray.size(); j++)
    {
        LocalDate firstDate = LocalDate.of(Integer.parseInt(peopleArray.get(i).getDOBYear()), 
                                  Integer.parseInt(peopleArray.get(i).getDOBMonth()), 
                                  Integer.parseInt(peopleArray.get(i).getDOBDay()));

        LocalDate secondDate= LocalDate.of(Integer.parseInt(peopleArray.get(j).getDOBYear()), 
              Integer.parseInt(peopleArray.get(j).getDOBMonth()), 
              Integer.parseInt(peopleArray.get(j).getDOBDay()));

        if(firstDate.isAfter(secondDate)) 
        {
            Person temp = peopleArray[i];
            peopleArray[i] = peopleArray[j];
            peopleArray[j] = temp;
         }              
    }
}