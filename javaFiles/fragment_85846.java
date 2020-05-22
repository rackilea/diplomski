kernel void struct_layout(global unsigned long* totalSize, global unsigned long* fieldOffsets)
{
    tpoint theStruct;
    totalSize[0] = sizeof(theStruct);
    unsigned long baseOffset = (unsigned long)&theStruct;
    fieldOffsets[0] = (unsigned long)&theStruct.x - baseOffset;
    fieldOffsets[1] = (unsigned long)&theStruct.y - baseOffset;
}