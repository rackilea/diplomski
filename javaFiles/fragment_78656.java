long offset = 0;
long quantum = 1024*1024; // or however much you want to transfer at a time
long count;
while ((count = out.transferFrom(in, offset, quantum)) > 0)
{
    offset += count;
}