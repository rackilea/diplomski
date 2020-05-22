public String getEnum(String number) {
                            String data = number.replaceAll("[^0-9]","");
                            StringBuffer sb = new StringBuffer();
                            for (int i = data.length()-1; i >= 0; i--)
                            {
                                    sb.append(data.charAt(i)).append('.');
                            }
                            sb.append("e164.arpa.");
                            return sb.toString();
                    }