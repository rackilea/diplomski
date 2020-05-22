CREATE PROCEDURE [dbo].[sp_getTask] 
    -- Add the parameters for the stored procedure here
    @actionTypeParam nvarchar(50) = '', 
    @serverNameParam nvarchar(10) = ''
AS
BEGIN
    -- SET NOCOUNT ON added to prevent extra result sets from
    -- interfering with SELECT statements.
    SET NOCOUNT ON;

    -- Insert statements for procedure here
    SELECT TOP 1 actionId, actionType, partner, fileProt FROM dbo.Ordonnancement WHERE actionType = @actionTypeParam AND serverName = @serverNameParam AND actionState = 'ACTIVE' ORDER BY actionRetry ASC, actionLocalDateTime ASC;
END
GO