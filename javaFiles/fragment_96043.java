for ( int i = 0; i < responses.size(); i++ )
{
     final int id = i; // save your variable

     ...
     try
     {
       NextStep(guideStep.getStep(), guideStep.getSession(), 
            guideStep.getResponse( id ).getId() ); // use it
     }
     ....
}