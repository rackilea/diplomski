String readBuff = buff.readLine();
                String section = "";
                while (readBuff != null){
                    if (section.equals("source_files {") && !readBuff.equals("}")){
                        sourceFiles.add(readBuff);
                    } else if (section.equals("clone_pairs {") && !readBuff.equals("}")){
                        clonePairs.add(readBuff);
                    } else if (readBuff.equals("source_files {") || readBuff.equals("clone_pairs {")) {
                        section = readBuff;
                    } else if (readBuff.equals("}")) {
                        section = "";
                    }

                    readBuff = buff.readLine();
                }