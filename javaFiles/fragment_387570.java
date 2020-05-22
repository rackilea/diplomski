IntStream.range(0,10)
      .parallel()
      .mapToObject(i -> getDevice())
      .forEach(device -> device.execute());

// Or shorter:
IntStream.range(0,10)
      .parallel()
      .forEach(i -> getDevice().execute());