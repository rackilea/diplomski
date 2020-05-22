public static void combination(char[] arr, int index, int b, StringBuffer sb)
    {
        for (int i = index; i <= b; i++)
        {
            System.out.println("i :" + i);
            sb.append(arr[i]);
            System.out.println(sb);
            combination(arr, i + 1, b, sb);
            System.out.println("setting length:" + (sb.length() -1) + ": index :" + index);
            sb.setLength(sb.length() - 1);
        }
    }