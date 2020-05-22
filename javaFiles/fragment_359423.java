public int missingNumber(int[] arr) {
    int length = arr.length;

    int indexes = 8;
    int values = 0;

    for (int i = 0; i < length; i++) {
        indexes += i + 1;
        values += arr[i];
    }

    return indexes - values;
}

@Test
public void testResultFor_1_2_3_5_6_7_8() {
    int result = missingNumber(new int[]{1, 2, 3, 5, 6, 7, 8});
    Assert.assertEquals(4, result);
}