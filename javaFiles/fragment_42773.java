// constants
companion object {
    const val TYPE_YOU = 1
    const val TYPE_ME = 2
}

/* This method is called to determine what type of ViewHolder should be used to represent item at [position] */
override fun getItemViewType(position: Int) = if(messages[position].who == "you") TYPE_YOU else TYPE_ME

/* [viewType] determines what ViewHolder we should create. */
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val layoutId = when(viewType){
        TYPE_YOU -> {
            // this viewholder will display only messages from "you", inflate only "you" layout
            R.layout.chat_item_you
        }
        TYPE_ME ->{
            // this viewholder will display only messages from "me", inflate only "me" layout
            R.layout.chat_item_me
        }
        else -> throw IllegalArgumentException("Unknown viewType: $viewType")
    }
    val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    return ViewHolder(itemView)
}

// then you can use your original bind method, because "you" and "me" messages will never re-user others ViewHolder
override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val msg = messages[position]

    if (msg.who == "you"){
        // holder.itemViewtype should always be equal to TYPE_YOU here
    }else{
        // holder.itemViewtype should always be equal to TYPE_ME here           
    }

    holder.message.text = msg.message
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val txtMessage : TextView = itemView.findViewById(R.id.message)
}