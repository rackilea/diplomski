const webdriver = require('selenium-webdriver');
const Capabilities = require('selenium-webdriver/lib/capabilities').Capabilities;

var capabilities = Capabilities.firefox();

// Tell the Node.js bindings to use Marionette.
// This will not be necessary in the future,
// when Selenium will auto-detect what remote end
// it is talking to.
capabilities.set('marionette', true);

var driver = new webdriver.Builder().withCapabilities(capabilities).build();