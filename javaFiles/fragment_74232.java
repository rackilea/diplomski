-     bool AggressiveOpts                           := false           {product}
+     bool AggressiveOpts                           := true            {product}

-     intx AutoBoxCacheMax                           = 128             {C2 product}
+     intx AutoBoxCacheMax                           = 20000           {C2 product}

-     intx BiasedLockingStartupDelay                 = 4000            {product}
+     intx BiasedLockingStartupDelay                 = 500             {product}

-     bool UseFPUForSpilling                         = false           {C2 product}
+     bool UseFPUForSpilling                         = true            {C2 product}