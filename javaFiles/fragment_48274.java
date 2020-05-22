@BindingAdapter("contractorItems")
fun setContractors(recyclerView: RecyclerView, items: List<Contractor>) {
    with(recyclerView.adapter as ContractorAdapter) {
        replaceData(items)
    }
}