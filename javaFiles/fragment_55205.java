FileInputStream fileInputStream = null;
                        File fileObj = new File(outputFile);
                        byte[] data = new byte[(int) fileObj.length()];

                        try {
                            //convert file into array of bytes
                            fileInputStream = new FileInputStream(fileObj);
                            fileInputStream.read(data);
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        ParseFile parseAudioFile = new ParseFile("audiofile.mp3", data);
                        parseAudioFile.saveInBackground();

                        ParseObject parseObject = new ParseObject("AudioFileClass");
                        parseObject.put("audiofile", parseAudioFile);
                        parseObject.saveInBackground(new SaveCallback() {
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(getApplicationContext(),"Audio file saved successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(),"Error: audio file not saved", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });