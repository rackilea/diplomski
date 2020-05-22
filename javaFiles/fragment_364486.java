public void returnCoreUnitsForProgram( int index )
{   
    if (ProgramArray.get(index).getProgramMajor().equals("Software Technology"))
    {                      
       for(int i = 0; i< UnitArray.size(); i++)
       {
           if (UnitArray.get(i).getUnitType().equals("Core"))
               System.out.println( UnitArray.get(i).getUnitName() );
       }                
    }                
}