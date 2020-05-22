val displayMetrics = context.resources.displayMetrics
val dpValue1 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f, displayMetrics)
val dpValue2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500f, displayMetrics)

mPopupWindow = new PopupWindow(
            PopUpView,
            dpValue1,
            dpValue2
    );