public Object push(element)
{

    if (filearray[filearray.length - 1] != null)
    {
        Object temp_array[] = new Object[filearray.length*2];
        int origonal = filearray.length*2;
        //adding the element that the user passed in
        temp_array[0] = element;
        for(int i =0; i<filearray.length;i++)
        {
            temp_array[i+1] =filearray[i];
        }

        this.filearray = temp_array;
    }
}