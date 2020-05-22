try                                                                                                                                     
{                                                                     
    FileSystem fs = FileSystem.get(job);                                                                                         
    FileStatus [] fileStatuses = fs.listStatus(new Path("/path/to/dir/"));                               
    LongWritable key = new LongWritable();                                                                                       
    BytesRefArrayWritable value = new BytesRefArrayWritable();                                                                   
    int counter = 1;                                                                                                             
    for (int i = 0; i < fileStatuses.length; i++)                                                                                
    {                                                                                                                            
        FileStatus fileStatus = fileStatuses[i];                                                                                 
        if (!fileStatus.isDir())                                                                                                 
        {                                                                                                                        
            System.out.println("File: " + fileStatus);                                                                           
            FileSplit split = new FileSplit(fileStatus.getPath(), 0, fileStatus.getLen(), job);                                  
            RCFileRecordReader reader = new RCFileRecordReader(job, split);                                                      
            while (reader.next(key, value))                                                                                      
            {                                                                                                                    
                System.out.println("Getting row " + counter);                                                                    
                AllCountriesRow acr = AllCountriesRow.valueOf(value);                                                            
                System.out.println("ROW: " + acr);                                                                                                                                                        
                counter++;                                                                                                       
            }                                                                                                                    
        }                                                                                                                        
    }                                                                                                                                                                                                                                                         
}                                                                                                                                
catch (IOException e)                                                                                                            
{                                                                                                                                
    throw new Error(e);                                                                                                          
}