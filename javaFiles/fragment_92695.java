@ManyToOne
@JoinColumn(name = "TRADING_SERIES_ID", nullable = false)
private TradingSeries tradingSeries;

@ManyToOne
@JoinColumn(name = "TRADING_SESSION_ID", nullable = false)
private TradingSession tradingSession;