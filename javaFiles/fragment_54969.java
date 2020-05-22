// With no other arguments
logger.warn("Something bad happened", exception);

// With a regular (non-structured) argument
logger.warn("Something bad happened with {}", "foo", exception);

// With a structured argument
logger.warn("Something bad happened with {}", kv("foo", "bar"), exception);