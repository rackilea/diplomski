4586     public void More ...setEnabled(boolean enabled) {
4587         if (enabled == isEnabled()) return;
4588 
4589         setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
4590 
4591         /*
4592          * The View most likely has to change its appearance, so refresh
4593          * the drawable state.
4594          */
4595         refreshDrawableState();
4596 
4597         // Invalidate too, since the default behavior for views is to be
4598         // be drawn at 50% alpha rather than to change the drawable.
4599         invalidate(true);
4600     }