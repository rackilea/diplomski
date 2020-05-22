int[] numList=new int[5];
    String[] list =  textFieldInput.getText().split(" ");
            for (int i = 0; i < list.length; i++){
                 numList[i] = Integer.parseInt(list[i]);
              }
              System.out.println(Arrays.toString(numList));