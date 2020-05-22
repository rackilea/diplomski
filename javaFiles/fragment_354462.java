case 1:  
            FileOutputStream fileOut = new FileOutputStream("Example.txt");
            BufferedOutputStream buffOut = new BufferedOutputStream(fileOut);
            DataOutputStream dOutput =new DataOutputStream (buffOut);
            for (int i = 0; i < numbers.length; i ++) {
                dOutput.writeInt(numbers[i]);
            }
            System.out.print("writing data ");  
            dOutput.close();
            break;