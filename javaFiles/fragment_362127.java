MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Log.d("UI thread", "I am the UI thread");
                        try{
                            ListView lv = (ListView) findViewById(R.id.listView1);
                            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
                            SAXParser parser = parserFactory.newSAXParser();
                            DefaultHandler handler = new DefaultHandler(){
                                String currentValue = "";
                                boolean currentElement = false;
                                public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
                                    currentElement = true;
                                    currentValue = "";
                                    if(localName.equals("item")){
                                        rss = new HashMap<>();
                                    }
                                }
                                public void endElement(String uri, String localName, String qName) throws SAXException {
                                    currentElement = false;
                                    if (localName.equalsIgnoreCase("title"))
                                        rss.put("title", currentValue);
                                    else if (localName.equalsIgnoreCase("description"))
                                        rss.put("description", currentValue);
                                    else if (localName.equalsIgnoreCase("link"))
                                        rss.put("link", currentValue);
                                    else if (localName.equalsIgnoreCase("georss:point"))
                                        rss.put("georss:point", currentValue);
                                    else if (localName.equalsIgnoreCase("author"))
                                        rss.put("author", currentValue);
                                    else if (localName.equalsIgnoreCase("comments"))
                                        rss.put("comments", currentValue);
                                    else if (localName.equalsIgnoreCase("pubDate"))
                                        rss.put("pubDate", currentValue);
                                    else if (localName.equalsIgnoreCase("item"))
                                        RSSList.add(rss);
                                }
                                @Override
                                public void characters(char[] ch, int start, int length) throws SAXException {
                                    if (currentElement) {
                                        currentValue = currentValue +  new String(ch, start, length);
                                    }
                                }
                            };
                            parser.parse(new InputSource(new StringReader(result)), handler);
                            ListAdapter adapter = new SimpleAdapter(MainActivity.this, RSSList, R.layout.list_row,new String[]{"title","description","link","georss:point","author","comments","pubDate"},
                                    new int[]{R.id.title, R.id.description, R.id.link, R.id.georss, R.id.author, R.id.comments, R.id.pubdate});
                            lv.setAdapter(adapter);
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParserConfigurationException e) {
                            e.printStackTrace();
                        } catch (SAXException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }