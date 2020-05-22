Exchanger<String> e = new Exchanger<>();

// Producer loop
e.exhange(generateNewData());  // Ignore consumer's response

// Consumer loop
processData(e.exchange(null)); // Get data, send dummy back