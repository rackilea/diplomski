ALTER PROCEDURE dbo.usp_verificarTabelaCadMov
      @NomeTabela VARCHAR(20)
AS
BEGIN
      SET NOCOUNT ON;

      DECLARE @Exists INT

      IF EXISTS(SELECT name
                        FROM sysobjects
                        WHERE name = @NomeTabela)
      BEGIN
            SET @Exists = 1
      END
      ELSE
      BEGIN
            SET @Exists = 0
      END

      RETURN @Exists
END