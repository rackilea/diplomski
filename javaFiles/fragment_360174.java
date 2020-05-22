class Style : Stylesheet() {
    companion object {
        val pass by cssclass()
        val fail by cssclass()
    }
    init {
        pass{
            backgroundColor += c("#4CAF50", .5)
            and(selected){
                backgroundColor += c("#0096C9", .5)
            }
        }
        fail{
            backgroundColor += c("#FF5722", .5)
            and(selected){
                backgroundColor += c("#0096C9", .5)
            }
        }
    }
}