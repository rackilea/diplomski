try {
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(conn.getInputStream()));
      try {
        String line = reader.readLine();

        if (line == null || line.equals("")) {
          throw new IOException("Received empty response from GCM service.");
        }
        String[] responseParts = split(line);
        String token = responseParts[0];
        String value = responseParts[1];
        if (token.equals(TOKEN_MESSAGE_ID)) {
          Builder builder = new Result.Builder().messageId(value);
          // check for canonical registration id
          line = reader.readLine();
          if (line != null) {
            responseParts = split(line);
            token = responseParts[0];
            value = responseParts[1];
            if (token.equals(TOKEN_CANONICAL_REG_ID)) {
              builder.canonicalRegistrationId(value);
            } else {
              logger.warning("Received invalid second line from GCM: " + line);
            }
          }

          Result result = builder.build();
          if (logger.isLoggable(Level.FINE)) {
            logger.fine("Message created succesfully (" + result + ")");
          }
          return result;
        } else if (token.equals(TOKEN_ERROR)) {
          return new Result.Builder().errorCode(value).build();
        } else {
          throw new IOException("Received invalid response from GCM: " + line);
        }
      } finally {
        reader.close();
      }
    } finally {
      conn.disconnect();
    }