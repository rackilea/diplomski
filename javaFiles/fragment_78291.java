int i = 123;
String s = (new StringBuilder()).append(i).toString();
String t = Integer.toString(i);
System.out.println((new StringBuilder(String.valueOf(s))).append(t).toString());

    public static void main(String args[])
    {
    //    0    0:bipush          123
    //    1    2:istore_1
    //    2    3:new             #16  <Class StringBuilder>
    //    3    6:dup
    //    4    7:invokespecial   #18  <Method void StringBuilder()>
    //    5   10:iload_1
    //    6   11:invokevirtual   #19  <Method StringBuilder StringBuilder.append(int)>
    //    7   14:invokevirtual   #23  <Method String StringBuilder.toString()>
    //    8   17:astore_2
    //    9   18:iload_1
    //   10   19:invokestatic    #27  <Method String Integer.toString(int)>
    //   11   22:astore_3
    //   12   23:getstatic       #32  <Field PrintStream System.out>
    //   13   26:new             #16  <Class StringBuilder>
    //   14   29:dup
    //   15   30:aload_2
    //   16   31:invokestatic    #38  <Method String String.valueOf(Object)>
    //   17   34:invokespecial   #44  <Method void StringBuilder(String)>
    //   18   37:aload_3
    //   19   38:invokevirtual   #47  <Method StringBuilder StringBuilder.append(String)>
    //   20   41:invokevirtual   #23  <Method String StringBuilder.toString()>
    //   21   44:invokevirtual   #50  <Method void PrintStream.println(String)>
    //   22   47:return
    }