/** Request the Google Play access token */
      private def getAccessToken(): Future[String] = {

        ws.url("https://www.googleapis.com/oauth2/v4/token")
          .withHeaders("Content-Type" -> "application/x-www-form-urlencoded")
          .post(
            Map(
              "grant_type" -> Seq("urn:ietf:params:oauth:grant-type:jwt-bearer"),
              "assertion" -> Seq(generateJWT()))
          ).map {
          response =>
            try {
              (response.json \ "access_token").as[String]
            } catch {
              case ex: Exception => throw new IllegalArgumentException("GooglePlayAPI - Invalid response: ", ex)
            }
        }

      }