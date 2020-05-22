private fun applyScaleAndTranslationToChild() {
        child().scaleX = scaleFactor
        child().scaleY = scaleFactor
        child().pivotX = 0f  // default is to pivot at view center
        child().pivotY = 0f  // default is to pivot at view center
        child().translationX = translateX
        child().translationY = translateY
    }