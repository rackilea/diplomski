//Creating a 1D array of AmountInfo type
jshell> Array.newInstance(AmountInfo.class, 2)
$65 ==> AmountInfo[2] { null, null }

// Creating a 2D array of AmountInfo type
jshell> Array.newInstance(AmountInfo[].class, 2)
$66 ==> AmountInfo[2][] { null, null }