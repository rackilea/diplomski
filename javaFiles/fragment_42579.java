/* in prod, within your actual URLOpener */
return new InputStreamReader(urlConnection.getInputStream());

/* in test, for your mock URLOpener */
when(mockUrlOpener.openURL(expectedURL)).thenReturn(new StringReader(testJSON));

JSONValue value = JSONValue.parse(new BufferedReader(readerFromUrl));