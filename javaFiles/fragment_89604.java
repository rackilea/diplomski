int[] arr = {1, 2, 3, 4};
String toString = Arrays.toString(arr);

System.out.println(toString);

// we know it starts with [ and ] so we skip it
String[] items = toString.substring(1, toString.length() - 1).split(",");
int[] arr2 = new int[items.length];
for (int i = 0; i < items.length; ++i)
{
    arr2[i] = Integer.parseInt(items[i].trim()); // .trim() because it adds the space and parseInt don't like spaces
}

System.out.println(Arrays.toString(arr2));