int val = b;
for (int i = 0; i < 8; i++)
{
    binary.insert(0, (val & 1) == 0 ? 0 : 1);
    val >>>= 1;
}
binary.insert(0, ' ');