// Allow this code to be run by non-root users on Linux/Unix
Settings settings = new MapSettings();
settings.put(Keys.PORT_KEY, 4427);

// Create the SLP UserAgentClient that discovers services
UserAgentClient userAgentClient = SLP.newUserAgentClient(settings);