include "application.conf"

play {
  modules {
    enabled += "com.github.mumoshu.play2.memcached.MemcachedModule"
    disabled += "play.api.cache.EhCacheModule"
  }
}