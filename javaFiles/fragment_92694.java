@ManyToOne
@PrimaryKeyJoinColumn(name = "TRADING_SERIES_ID")
private TradingSeries tradingSeries;

@ManyToOne
@PrimaryKeyJoinColumn(name = "TRADING_SESSION_ID")
private TradingSession tradingSession;