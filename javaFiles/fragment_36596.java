case com.android.internal.R.styleable.View_visibility:
    final int visibility = a.getInt(attr, 0);
    if (visibility != 0) {
          viewFlagValues |= VISIBILITY_FLAGS[visibility]; //here is the key to your question
          viewFlagMasks |= VISIBILITY_MASK;
    }
    break;