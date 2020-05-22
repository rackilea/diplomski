/**
   * Wait for the completed result and return it. If the result is not available within this
   * timeout, throw a [[RpcTimeoutException]] to indicate which configuration controls the timeout.
   * @param  awaitable  the `Awaitable` to be awaited
   * @throws RpcTimeoutException if after waiting for the specified time `awaitable`
   *         is still not ready
   */
  def awaitResult[T](awaitable: Awaitable[T]): T = {
    try {
      Await.result(awaitable, duration)
    } catch addMessageIfTimeout
  }
}