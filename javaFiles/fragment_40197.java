// SETUP SUT
RepeatRejectAnalysis_Listener yourRraListener = new RepeatRejectAnalysis_Listener(); 

// EXERCISE
yourClass.addListener(yourRraListener);

// VERIFY
Mockito.verify(Save_Button, Mockito.times(1)).addActionListener(yourRraListener);
Mockito.verify(Cancel_Button, Mockito.times(1)).addActionListener(yourRraListener);