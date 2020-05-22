@Test
public void removeme() {
    String input = "111?111111";
    int sum = 0;
    int temp = 0;
    for(int i = 0; i < input.length(); i++){
        char a = input.charAt(i);
        if(a == 'x'){
            temp = 10;
        } else if(a == '?'){
            temp = 0;
        } else {
            temp = Character.getNumericValue(input.charAt(i));
        }

        sum = temp * (10 - i) + sum;
    }
    assertThat(sum , is(48));
}