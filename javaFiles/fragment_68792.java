public byte[] readBytes(long address, int length)
{
    val byteBuffer = allocate(length);

    var totalRemainingLength = length;
    var currentAddress = address;

    while (totalRemainingLength > 0)
    {
        val memoryBasicInformation = new MEMORY_BASIC_INFORMATION();
        val process = new HANDLE(processHandle);
        val pointer = new Pointer(currentAddress);
        val memoryPageQueryResult = KERNEL_32.VirtualQueryEx(process, pointer, memoryBasicInformation,
                new BaseTSD.SIZE_T(memoryBasicInformation.size()));
        if (memoryPageQueryResult.equals(new SIZE_T(0)))
        {
            throw new IllegalStateException("Memory not contiguous");
        }

        val memoryPageBaseAddress = nativeValue(memoryBasicInformation.baseAddress);
        val memoryPageSize = memoryBasicInformation.regionSize.longValue();
        val memoryPageEndAddress = memoryPageBaseAddress + memoryPageSize;

        val remainingMemoryPageBytes = memoryPageEndAddress - address;
        val currentLength = (int) min(totalRemainingLength, remainingMemoryPageBytes);
        val outputMemory = getOutputMemory(processHandle, currentAddress, currentLength);
        val byteArray = outputMemory.getByteArray(0, currentLength);
        byteBuffer.put(byteArray);

        currentAddress += currentLength;
        totalRemainingLength -= currentLength;
    }

    return byteBuffer.array();
}

static Memory getOutputMemory(Pointer openedProcess, long baseAddress, int length)
{
    val outputMemory = new Memory(length);
    val intByReference = new IntByReference();
    if (!MY_KERNEL_32.ReadProcessMemory(openedProcess, baseAddress,
            outputMemory, (int) outputMemory.size(), intByReference))
    {
        checkForKernelError();
    }

    return outputMemory;
}