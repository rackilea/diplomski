for( int i = 0; i < acts.length -1; i++ ) 
{
   if ( acts[i].getActionCost( ) == getMinValue( costs ) )
   { 
     System.out.println( "PRE The first parameter is : " +  
                        acts[i].getActParameter1() + acts[i].name );

     if ( acts[i].getActParameter1() == "plane" ) 
     {
        System.out.println( "POST The first parameter is : " + 
                            acts[i].getActParameter1() );
        System.out.println( "Precondition satysfied with action name: " + 
                            acts[i].name );

        if ( acts[i].getActParameter1() != state.getStateParameter1() ) 
        {
          state.setStateParameter1( acts[i].getActParameter1() );
        }

        if(acts[i].getActParameter2() != state.getStateParameter2()) 
        {
          state.setStateParameter2( acts[i].getActParameter2() );
        }

        if( acts[i].getActParameter3() != state.getStateParameter3() ) 
        {
          state.setStateParameter3( acts[i].getActParameter3() );
        }

        if( acts[i].getActParameter4() != state.getStateParameter4() ) 
        {
          state.setStateParameter4( acts[i].getActParameter4() );
        }

        if( acts[i].getActParameter5() != state.getStateParameter5() ) 
        {
          state.setStateParameter5( acts[i].getActParameter5() );
        }
    }

    Node child = new Node(state, startNode, acts[i].getActionCost());

    System.out.println( "Costs array: "+  Arrays.toString( costs ) );
    System.out.println( "ActionID" +" " +  i );
    System.out.println( "The action choosen is " + acts[i].name + 
                        acts[i].actionCost + acts[i].getActParameter1() );
    System.out.println( "State parameters updated are " + "pkg1Location: " + 
                        state.getStateParameter1() + " pkg2Location: " +
                        state.getStateParameter2() + " truckLocation: "+ 
                        state.getStateParameter3() + " planeLocation: " + 
                        state.getStateParameter4() + " cityLocation:"+ 
                        state.getStateParameter5());
  }
}