Map<String, Integer> result = new HashMap<String, Integer>();  
                File directory = new File(chooser.getSelectedFile().getAbsolutePath());   
                File[] files = directory.listFiles();  

                for (File file : files)  
                {  
                    if (file.isFile())  
                    {    
                        Scanner scanner = new Scanner(new FileReader(file));  
                        int lineCount = 0;  

                        try  
                        { for (lineCount = 0; scanner.nextLine() != null; lineCount++);  
                        } catch (NoSuchElementException e)  
                        {   result.put(file.getName(), lineCount);  
                        }  

                    }  
                }  

                int lineCounter = 0;  
                for (Map.Entry<String, Integer> entry : result.entrySet())  
                {  
                    System.out.println(entry.getKey() + " ==> " + entry.getValue());
                    lineCounter+=entry.getValue();  
                }  
                 System.out.println(String.valueOf(lineCounter));