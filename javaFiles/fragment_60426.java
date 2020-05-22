PointerByReference lngProcID;
    int lngProcHandle;
    LVITEM lvi;
    int strSize = 255;
    int result = 0;
    IntByReference byteIO = new IntByReference();
    Pointer lngVarPtr1 = null;Pointer lngMemVar1 = null;
    Pointer lngVarPtr2 = null;Pointer lngMemVar2 = null;
    Pointer lviVarPtr = null;Pointer lviVar = null;
    int lngMemLen1; int lngMemLen2;

    lngProcID = new PointerByReference();
    int ThreadId = user32.GetWindowThreadProcessId(hWnd, lngProcID);

    lngProcHandle = Kernel32.OpenProcess(Kernel32.PROCESS_VM_OPERATION | Kernel32.PROCESS_VM_WRITE | Kernel32.PROCESS_VM_READ, false, lngProcID.getValue());

    lvi = new LVITEM();
    lngMemLen1 = strSize;
    lngMemLen2 = lvi.size(); 

    lngMemVar2 = Kernel32.VirtualAllocEx(lngProcHandle, 0, lngMemLen2, Kernel32.MEM_RESERVE|Kernel32.MEM_COMMIT, Kernel32.PAGE_READWRITE);        

    lvi.cchTextMax = strSize;
    lvi.iItem = itemIdx;
    lvi.iSubItem = 0;
    lvi.mask = User32.LVIF_TEXT;
    lvi.pszText = lngMemVar1;       

    //result  = Kernel32.WriteProcessMemory(lngProcHandle, lngMemVar1, lngVarPtr1, lngMemLen1, byteswritten1);
    result = Kernel32.WriteProcessMemory(lngProcHandle, lngMemVar2, lvi, lngMemLen2, byteIO);

    result = user32.SendMessage (hWnd, User32.LVM_GETITEM, 0, lngMemVar2);

   lngVarPtr1 = new Memory(strSize + 1);
   result = Kernel32.ReadProcessMemory(lngProcHandle, lngMemVar1, lngVarPtr1, lngMemLen1, byteIO);

    result = Kernel32.VirtualFreeEx (lngProcHandle, lngMemVar1, 0, Kernel32.MEM_RELEASE);
    result = Kernel32.VirtualFreeEx (lngProcHandle, lngMemVar2, 0, Kernel32.MEM_RELEASE);        
    result = Kernel32.CloseHandle(lngProcHandle);

    return lngVarPtr1.getWideString(0);