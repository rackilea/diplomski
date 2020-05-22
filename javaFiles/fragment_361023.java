long total = 0;
while (total < size && (count = in.read(buffer, 0, size-total > buffer.length ? buffer.length : (int)(size-total))) > 0)
{
    fos.write(buffer, 0, count);
    total += count;
}
fos.close();