class RefreshMainDataWork(context: Context, params: WorkerParameters) :
        CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            // Retrieve data
            // Sync Data asynchronously with a suspended function
            Result.success()
        } catch (error: TitleRefreshError) {
            Result.failure()
        }
    }
}