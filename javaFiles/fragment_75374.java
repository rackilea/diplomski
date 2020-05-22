// Set the page load timeout to 10 seconds.
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

try {
  driver.get("http://url/to/my/slow/loading/page");
} catch (TimeoutException e) {
  // Ignore the exception.
}

// Proceed with your next step here.