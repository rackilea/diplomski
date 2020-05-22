HashMap<String, Object> args = new HashMap<>();
args.put("bundleId", "com.apple.safari");
driver.executeScript("mobile: launchApp", args);
//Navigate to your email, etc.

// re-activate your native app and use it
args.put("bundleId", yourAppBundleId);
driver.executeScript("mobile: activateApp", args);