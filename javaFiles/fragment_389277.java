/**
!      * Ensures that loads before the fence will not be reordered with loads and
!      * stores after the fence; a "LoadLoad plus LoadStore barrier".
!      *
!      * Corresponds to C11 atomic_thread_fence(memory_order_acquire)
!      * (an "acquire fence").
!      *
!      * A pure LoadLoad fence is not provided, since the addition of LoadStore
!      * is almost always desired, and most current hardware instructions that
!      * provide a LoadLoad barrier also provide a LoadStore barrier for free.
       * @since 1.8
       */
      public native void loadFence();

      /**
!      * Ensures that loads and stores before the fence will not be reordered with
!      * stores after the fence; a "StoreStore plus LoadStore barrier".
!      *
!      * Corresponds to C11 atomic_thread_fence(memory_order_release)
!      * (a "release fence").
!      *
!      * A pure StoreStore fence is not provided, since the addition of LoadStore
!      * is almost always desired, and most current hardware instructions that
!      * provide a StoreStore barrier also provide a LoadStore barrier for free.
       * @since 1.8
       */
      public native void storeFence();

      /**
!      * Ensures that loads and stores before the fence will not be reordered
!      * with loads and stores after the fence.  Implies the effects of both
!      * loadFence() and storeFence(), and in addition, the effect of a StoreLoad
!      * barrier.
!      *
!      * Corresponds to C11 atomic_thread_fence(memory_order_seq_cst).
       * @since 1.8
       */
      public native void fullFence();