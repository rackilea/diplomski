override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.card?.viewTreeObserver?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                holder.card?.getViewTreeObserver()?.removeGlobalOnLayoutListener(this);
                Log.e("widths", holder.card?.measuredWidth.toString())
            }
        })
        Log.e("text","i am here")
    }