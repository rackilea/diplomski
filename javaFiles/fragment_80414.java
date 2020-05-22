fun setPageNumber(number: Int) {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        currentX = (number * displayMetrics.widthPixels) + PADDING_OFFSET
        scrollTo(currentX + PADDING_OFFSET, 0)
    }