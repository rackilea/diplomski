try {                                                       
                        JsonSerializer<Date> ser = new JsonSerializer<Date>() {

                            @Override
                            public JsonElement serialize(Date src, Type typeOfSrc,
                                    JsonSerializationContext comtext) {

                                return src == null ? null : new JsonPrimitive("/Date("+src.getTime()+"+05300)/");
                            }
                        };
                        JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {                           
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext jsonContext) throws JsonParseException {

                                String tmpDate = json.getAsString();

                                  Pattern pattern = Pattern.compile("\\d+");
                                  Matcher matcher = pattern.matcher(tmpDate);
                                  boolean found = false;

                                  while (matcher.find() && !found) {
                                       found = true;
                                        tmpDate = matcher.group();
                                  }
                                return json == null ? null : new Date(Long.parseLong(tmpDate));                             
                            }
                        };