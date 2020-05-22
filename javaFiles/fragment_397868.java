void readInputField(){
            String inputField; //string in which input is stored
            inputField = ". . . . . . . . . . . . . * .\n" +
                    ". . . . . . . . . . . . * . .\n" +
                    ". . . . . . . . . . . . * * *\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    "* * * * * * * * . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .\n" +
                    ". . . . . . . . . . . . . . .";
            int height = 10;
            int width = 10;
            String[][] fieldParts; //array in which I want to store Strings of inputField
            fieldParts = new String[height][width]; //width and height are determined
            //by earlier scanner input and correspond to the dimensions of the input array
            String val[] = inputField.split("\n");
            for(int i=0;i<height;i++){
                String wd[] = val[i].split(" ");
                for(int j=0;j<width;j++){
                    fieldParts[i][j] = wd[j];
                }
            }
        }