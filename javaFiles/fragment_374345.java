Object[][] array = new Object[dataList.size()][];
int i = 0;
for (DataClass c : dataList)
{
    array[i] = new Object[7];
    array[i][0] = c.x;
    array[i][1] = c.y;
    array[i][2] = c.z;
    array[i][3] = c.string1;
    array[i][4] = c.string2;
    array[i][5] = c.date;
    array[i][6] = c.event;
    i++;
}