@CollectionOfElements(targetClass = Country.class)
@JoinTable(name = "provider_country", joinColumns = @JoinColumn(name = "provider_id"))
@Column(name = "country", nullable = false)
@Enumerated(EnumType.STRING)
public Collection<Country> getCountries() {
    return countries;
}

@CollectionOfElements(targetClass = Currency.class)
@JoinTable(name = "provider_currency", joinColumns = @JoinColumn(name = "provider_id"))
@Column(name = "currency", nullable = false)
@Enumerated(EnumType.STRING)
public Collection<Currency> getCurrencies() {
    return currencies;
}