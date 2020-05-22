import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BoundsSQL implements SQLData
{
  public static final String SQL_TYPE = "BD_TB_STRUCT";
  public java.sql.Timestamp start;
  public java.sql.Timestamp end;
  public BigInteger type;
  public BigInteger duration;

  public BoundsSQL()
  {
  }

  public BoundsSQL(
      final int year,
      final int month,
      final int dayOfMonth,
      final int hour,
      final int minute,
      final int seconds,
      final long duration,
      final long type )
  {
    final long epochSeconds = LocalDateTime.of(
        year,
        month,
        dayOfMonth,
        hour,
        minute,
        seconds
      ).toEpochSecond( ZoneOffset.UTC );
    this.start    = new Timestamp( epochSeconds * 1000 );
    this.end      = new Timestamp( (epochSeconds + duration) * 1000 );
    this.duration = BigInteger.valueOf( duration );
    this.type = BigInteger.valueOf( type );
  }

  @Override
  public String getSQLTypeName() throws SQLException
  {
    return SQL_TYPE;
  }

  @Override
  public void readSQL( SQLInput stream,
      String typeName ) throws SQLException
  {
    start    = stream.readTimestamp();
    end      = stream.readTimestamp();
    type     = stream.readBigDecimal().toBigInteger();
    duration = stream.readBigDecimal().toBigInteger();
  }

  @Override
  public void writeSQL( SQLOutput stream ) throws SQLException
  {
    stream.writeTimestamp( start );
    stream.writeTimestamp( end );
    stream.writeBigDecimal( new BigDecimal( type ) );
    stream.writeBigDecimal( new BigDecimal( duration ) );
  }

  @Override
  public String toString()
  {
    return String.format(
        "Start:    %s\nEnd:      %s\nDuration: %s\nType:     %s",
        start,
        end,
        duration,
        type
    );
  }
}