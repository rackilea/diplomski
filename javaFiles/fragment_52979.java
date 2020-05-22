public SSLParameters customize(SSLParameters sslParams)
{
    super.customize(sslParams);
    _selectedCipherSuites = // String[] of selected cipher suites on IBM J9
    sslParams.setCipherSuites(_selectedCipherSuites);
}