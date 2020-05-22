e.printStackTrace();
        }
       }
    }

    private void writeToFile(InputStream in) throws IOException {
        // Write the output audio in byte
        String filePath = "8k16bitMono1.wav";
        short sData[] = new short[1024];