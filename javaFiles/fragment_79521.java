<PassengerDetailsRQ version="3.1.0" xmlns="http://services.sabre.com/sp/pd/v3_1&quot; IgnoreOnError="true">
     <MiscSegmentSellRQ> 
        <MiscSegment DepartureDateTime="11-28" NumberInParty="3" Status="NN" Type="OTH"> 
            <OriginLocation LocationCode="ISB"/> 
            <Text>RETENTION SEGMENT</Text> 
            <VendorPrefs> 
                <Airline Code="PK"/> 
            </VendorPrefs> 
        </MiscSegment> 
    </MiscSegmentSellRQ> 
    <PostProcessing RedisplayReservation="true" UnmaskCreditCard="true"> 
        <EndTransactionRQ> 
            <EndTransaction Ind="true"/> 
            <Source ReceivedFrom=" TESTING"/> 
        </EndTransactionRQ>
    </PostProcessing> 
    <PriceQuoteInfo> 
        <Link NameNumber="1.1" Record="1"/> 
        <Link NameNumber="2.1" Record="1"/> 
        <Link NameNumber="3.1" Record="2"/> 
        <Link NameNumber="4.1" Record="3"/> 
    </PriceQuoteInfo> 
    <SpecialReqDetails> 
        <AddRemarkRQ> 
            <RemarkInfo> 
                <FOP_Remark Type="CASH"/> 
            </RemarkInfo> 
        </AddRemarkRQ> 
        <SpecialServiceRQ> 
            <SpecialServiceInfo> 
                <SecureFlight SegmentNumber="A" SSR_Code="DOCS"> 
                    <PersonName DateOfBirth="1975-07-25" Gender="M" NameNumber="1.1"> 
                        <GivenName>CHAN</GivenName> 
                        <Surname>JOHN</Surname> 
                    </PersonName>
                    <VendorPrefs> 
                        <Airline Hosted="false"/>
                    </VendorPrefs> 
                </SecureFlight> 
                <SecureFlight SegmentNumber="A" SSR_Code="DOCS"> 
                    <PersonName DateOfBirth="1987-07-21" Gender="F" NameNumber="2.1"> 
                        <GivenName>WIFE</GivenName> 
                        <Surname>JOHN</Surname> 
                    </PersonName> 
                    <VendorPrefs> 
                        <Airline Hosted="false"/> 
                    </VendorPrefs> 
                </SecureFlight> 
                <SecureFlight SegmentNumber="A" SSR_Code="DOCS"> 
                    <PersonName DateOfBirth="2010-09-08" Gender="M" NameNumber="3.1"> 
                        <GivenName>CHILD</GivenName> 
                        <Surname>JOHN</Surname> 
                    </PersonName> 
                    <VendorPrefs> 
                        <Airline Hosted="false"/> 
                    </VendorPrefs> 
                </SecureFlight> 
                <Service SSR_Code="INFT"> 
                    <PersonName NameNumber="1.1"/> 
                        <Text> JOHN/INFANT/25JUN15</Text> 
                        <VendorPrefs> 
                            <Airline Hosted="false"/> 
                        </VendorPrefs>
                </Service> 
            </SpecialServiceInfo> 
        </SpecialServiceRQ> 
    </SpecialReqDetails> 
    <TravelItineraryAddInfoRQ> 
        <AgencyInfo> 
            <Address> 
                <AddressLine>YATANGO TRAVEL</AddressLine> 
                <CityName>DSD</CityName> 
                <CountryCode>US</CountryCode> 
                <PostalCode>76092</PostalCode> 
                <StateCountyProv StateCode="TX"/> 
                <StreetNmbr>3150 DDDD DRIVE</StreetNmbr> 
            </Address>
            <Ticketing TicketType="7TAW"/> 
        </AgencyInfo> 
            <CustomerInfo> 
                <ContactNumbers> 
                    <ContactNumber LocationCode="SYD" NameNumber="1.1" Phone="817-555-1212" PhoneUseType="A"/> 
                    <ContactNumber LocationCode="SYD" NameNumber="1.1" Phone="972-555-1212" PhoneUseType="H"/> 
                </ContactNumbers> 
                <Email Address="damayantha@gmail.com" NameNumber="1.1"/> 
                <PersonName NameNumber="1.1" > 
                    <GivenName>CHAN</GivenName> 
                    <Surname>JOHN</Surname>
                </PersonName> 
                <PersonName NameNumber="2.1" > 
                    <GivenName>WIFE</GivenName> 
                    <Surname>JOHN</Surname> 
                </PersonName> 
                <PersonName NameNumber="3.1" NameReference="C04" > 
                    <GivenName>CHILD</GivenName> 
                    <Surname>JOHN</Surname> 
                </PersonName> 
                <PersonName NameNumber="4.1" Infant="true" NameReference="I02" > 
                    <GivenName>INFANT</GivenName> 
                    <Surname>JOHN</Surname> 
                </PersonName> 
            </CustomerInfo> 
    </TravelItineraryAddInfoRQ> 
</PassengerDetailsRQ>