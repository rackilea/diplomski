// oauth_nonce
var oauth_nonce = new Random().Next(123400, 9999999).ToString(CultureInfo.InvariantCulture);

// oauth_timestamp
TimeSpan ts = DateTime.UtcNow - new DateTime(1970, 1, 1, 0, 0, 0, 0, DateTimeKind.Utc);
var oauthTimestamp = Convert.ToInt64(ts.TotalSeconds).ToString(CultureInfo.InvariantCulture);