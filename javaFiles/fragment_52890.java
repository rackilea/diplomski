HotKeySet("{PAUSE}", "getInput")

While 1
    Sleep(100)
Wend


Func getInput()
    MouseClick("left",272,241,1)
    Sleep(100)
    MouseClick("left",272,241,1)
    Send("{SHIFTDOWN}")
    MouseClick("left",272,241,1)
    MouseClick("left",529,242,2)
    Send("{SHIFTUP}{CTRLDOWN}c{CTRLUP}")
    MouseClick("left",656,42,1)
    Sleep(100)  
    MouseClick("left",696,42,1)
    Send("{CTRLDOWN}a")
    Send("{DELETE}")
    Send("{CTRLDOWN}v{CTRLUP}")
    MouseClick("left",1178,44,1)
EndFunc