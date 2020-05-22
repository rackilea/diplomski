For Each Process in GetObject("winmgmts:").ExecQuery("Select * from Win32_Process where Handle =  " & WScript.Arguments.Item(0) &  "")
 WScript.echo Process.Handle & " " & Process.name & " " & CPUUSage(Process.Handle) & " %"   
Next

Function CPUUSage( ProcID )
  On Error Resume Next

Set objService = GetObject("Winmgmts:{impersonationlevel=impersonate}!\Root\Cimv2")

For Each objInstance1 in objService.ExecQuery("Select * from Win32_PerfRawData_PerfProc_Process where IDProcess = '" & ProcID & "'")
    N1 = objInstance1.PercentProcessorTime
    D1 = objInstance1.TimeStamp_Sys100NS
    Exit For
Next

 WScript.Sleep(2000)

For Each perf_instance2 in objService.ExecQuery("Select * from Win32_PerfRawData_PerfProc_Process where IDProcess = '" & ProcID & "'")
    N2 = perf_instance2.PercentProcessorTime
    D2 = perf_instance2.TimeStamp_Sys100NS
    Exit For
Next

Const wbemFlagReturnImmediately = &h10
Const wbemFlagForwardOnly = &h20
strComputer = "."

Set objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\CIMV2")
Set colItems = objWMIService.ExecQuery("SELECT * FROM Win32_Processor", "WQL", _
                                      wbemFlagReturnImmediately + wbemFlagForwardOnly)

For Each objItem In colItems
    Nc = objItem.NumberOfLogicalProcessors
Next

' CounterType - PERF_100NSEC_TIMER_INV
' Formula - (1- ((N2 - N1) / (D2 - D1))) x 100
Nd = (N2 - N1)
Dd = (D2 - D1)
' Nd/Dd = number of cores used.
' ((Nd/Dd)/Nc) * 100 = % of whole box used
PercentProcessorTime = ((Nd/Dd)/Nc)*100

CPUUSage = Round(PercentProcessorTime ,2)
End Function