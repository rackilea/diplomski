while ((count=inputStream.read(data))!=-1){

                if(!your_AsyncTask.isCancelled() ||  downloadstatus !=false){
                    total+=count;
                    outputStream.write(data,0,count);
                    int progress= (total*200)/file_length;
                    downloadedsize=total;

                    publishProgress(progress);
                }else{
                    break;
                }
            }