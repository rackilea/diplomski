fun failingFunction(resolveInfo:ResolveInfo){
    Log.d(TAG,"original label ${resolveInfo.loadLabel(this.packageManager)}")
    val p = Parcel.obtain()
    resolveInfo.writeToParcel(p, 0)
    p.setDataPosition(0)
    val copy = ResolveInfo.CREATOR.createFromParcel(p)
    Log.d(TAG,"copy label ${copy.loadLabel(this.packageManager)}") // no longer throws java.lang.IllegalStateException
}