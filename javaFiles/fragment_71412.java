private companion object : Parceler<CustomModel> {
    override fun CustomModel.write(parcel: Parcel, flags: Int) {
        parcel.writeByte((if (customField as Boolean) 1 else 0).toByte())
    }

    override fun create(parcel: Parcel): CustomModel {
        return CustomModel(
                _customField = parcel.readByte() != 0.toByte()
        )
    }
}