inner class ScaleListner : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(scaleDetector: ScaleGestureDetector?): Boolean {
            val scaleFactor = scaleDetector!!.scaleFactor
            setScaleAndTranslation(scaleFactor, scaleDetector.focusX, scaleDetector.focusY)
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
            super.onScaleEnd(detector)
            setLayoutParamOfChild()
        }

        private fun setScaleAndTranslation(scaleFactor: Float, focusX: Float, focusY: Float) {
            if (lastScaleFactor == 0f || Math.signum(scaleFactor) == Math.signum(lastScaleFactor)) {
                val prevScale = this@ZoomView.scaleFactor
                this@ZoomView.scaleFactor *= scaleFactor
                this@ZoomView.scaleFactor = Math.max(MIN_ZOOM, Math.min(this@ZoomView.scaleFactor, MAX_ZOOM))
                lastScaleFactor = scaleFactor
                val adjustedScaleFactor = this@ZoomView.scaleFactor / prevScale
                // added logic to adjust translateX and translateY for pinch/zoom pivot point
                translateX += (translateX - focusX) * (adjustedScaleFactor - 1)
                translateY += (translateY - focusY) * (adjustedScaleFactor - 1)
            } else {
                lastScaleFactor = 0f
            }
            isSingleTapConfirmed = false
        }
    }