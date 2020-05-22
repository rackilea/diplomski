ArrayList<String>arrayList = new ArrayList<>();
                    for(int a = 0; a < bitmap1.getWidth(); a++){
                        for(int b = 0; b < bitmap1.getHeight(); b++){
                            String a1 = String.valueOf(arrayInput1[a][b]);
                            String a2 = String.valueOf(arrayInput2[a][b]);
                            String a3 = String.valueOf(arrayInput3[a][b]);
                            String a4 = String.valueOf(arrayInput4[a][b]);
                            String a5 = String.valueOf(arrayInput5[a][b]);
                            String a6 = String.valueOf(arrayInput6[a][b]);
                            String a7 = String.valueOf(arrayInput7[a][b]);
                            String a8 = String.valueOf(arrayInput8[a][b]);
                            arrayList.add(a1+a2+a3+a4+a5+a6+a7+a8); // Store 1110001 into ArrayList
                        }
                    }