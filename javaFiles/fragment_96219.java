Collection<Request> bundle = new ArrayList<Request>();
    bundle.add(queue.take());
    while (bundle.size() < BUNDLE_MAX) {
      Request req = queue.poll(EXTRA, TimeUnit.MILLISECONDS);
      if (req == null)
        break;
      bundle.add(req);
    }
    /* Now make one service request with contents of "bundle". */