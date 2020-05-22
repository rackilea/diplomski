public static boolean isEthylFreezing(int temp) {
  int EthylF = -173;

  if (EthylF <= temp)
  {
    System.out.print("Ethyl will freeze at that temperature");
    return true;
  }
  else 
    return false;
}