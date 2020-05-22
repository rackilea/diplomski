public static void main(String args[])
{
//    0    0:ldc1            #16  <String "123">
//    1    2:astore_1
//    2    3:sipush          456
//    3    6:invokestatic    #18  <Method String Integer.toString(int)>
//    4    9:astore_2
//    5   10:getstatic       #24  <Field PrintStream System.out>
//    6   13:new             #30  <Class StringBuilder>
//    7   16:dup
//    8   17:aload_1
//    9   18:invokestatic    #32  <Method String String.valueOf(Object)>
//   10   21:invokespecial   #38  <Method void StringBuilder(String)>
//   11   24:aload_2
//   12   25:invokevirtual   #41  <Method StringBuilder StringBuilder.append(String)>
//   13   28:invokevirtual   #45  <Method String StringBuilder.toString()>
//   14   31:invokevirtual   #48  <Method void PrintStream.println(String)>
//   15   34:return
}