name = in.readLine();
if (name != null && !"".equals(name)) {
    String[] arr = name.split("\\s+");
    for (int i = 0; i < arr.length; i++)
        System.out.println(arr[i]);
}