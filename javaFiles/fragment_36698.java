@InitiatingFlow
@StartableByRPC
class AddAttachmentFlow(private val attachmentHashString: String) : FlowLogic<SignedTransaction>() {

    @Suspendable
    override fun call(): SignedTransaction {
        val notary: Party = TODO("Pick a notary.")

        val attachmentHash = SecureHash.parse(attachmentHashString)

        val txBuilder = TransactionBuilder(notary)
        txBuilder.addAttachment(attachmentHash)

        TODO("Finish building transaction and gathering required signatures.")
    }
}