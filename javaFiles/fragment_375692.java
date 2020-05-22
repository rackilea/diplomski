import static org.mockito.Mockito.*;
...

DelegateExecution mockExecution = mock(DelegateExecution.class);
doReturn("printJobId").when(mockExecution).getVariable(eq("VIP-Variable"));
cleanupVariables.execute(mockExecution);