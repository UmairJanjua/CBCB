import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

class SoapRequestTest {

//        System.setProperty("javax.net.ssl.trustStore", "/usr/lib/jvm/java-8-oracle/jre/lib/security/cacerts");
//        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
//        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
//
//        System.setProperty("javax.net.ssl.keyStore", "../../../certs/Private.pfx");
//        System.setProperty("javax.net.ssl.keyStorePassword", "Kreditech2017");
//        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");


    public static String payLoad(){

        String xml =
                "      <![CDATA[<RI_REQ xsi:noNamespaceSchemaLocation=\"RI_REQ_schema.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "      <TecData>\n" +
                "        <UserId>L******1</UserId>\n" +
                "        <Password>k******y</Password>\n" +
                "      </TecData>\n" +
                "      <Header>\n" +
                "        <FunctionCode>01001</FunctionCode>\n" +
                "        <ReleaseOfFunctionCode>1</ReleaseOfFunctionCode>\n" +
                "        <Service>EB</Service>\n" +
                "      </Header>\n" +
                "      <ContractData>\n" +
                "        <FlagAllowedToExchange>1</FlagAllowedToExchange>\n" +
                "        <OpNumber>tvy7y6</OpNumber>\n" +
                "        <OpPhase>ZD</OpPhase>\n" +
                "        <FinancingRequestDate>10092016</FinancingRequestDate>\n" +
                "        <OpType>FL</OpType>\n" +
                "        <NrOfInstalments>12</NrOfInstalments>\n" +
                "        <Periodicity>M</Periodicity>\n" +
                "        <MethodOfPayment></MethodOfPayment>\n" +
                "        <FinancedCapital-Credit>100000</FinancedCapital-Credit>\n" +
                "        <MonthlyInstalmentAmount></MonthlyInstalmentAmount>\n" +
                "        <CurrencyCode>CZK</CurrencyCode>\n" +
                "        <ChannelType>1</ChannelType>\n" +
                "      </ContractData>\n" +
                "      <AdditionalServices>\n" +
                "        <AdditionalScores>\n" +
                "          <ScoreModelId>FSI</ScoreModelId>\n" +
                "        </AdditionalScores>\n" +
                "        <IdCheck>0</IdCheck>\n" +
                "      </AdditionalServices>\n" +
                "      <CustomerType>1</CustomerType>\n" +
                "      <Customer>\n" +
                "        <FIPersonalCode>tvy7y6</FIPersonalCode>\n" +
                "        <RoleCode>A</RoleCode>\n" +
                "        <Individual>\n" +
                "          <Name>\n" +
                "            <PresentSurname-TradeName>Malik</PresentSurname-TradeName>\n" +
                "            <PresentName-OwnerPresentName>Asfandyar Ashraf</PresentName-OwnerPresentName>\n" +
                "            <NameForcing>0</NameForcing>\n" +
                "            <PresentSurnameForcing>0</PresentSurnameForcing>\n" +
                "            <OwnerPresentSurname>NEKONEČNÁ</OwnerPresentSurname>\n" +
                "            <BirthSurname>Malik</BirthSurname>\n" +
                "            <BirthSurnameForcing>0</BirthSurnameForcing>\n" +
                "          </Name>\n" +
                "          <PINInfo>\n" +
                "            <PIN>ssn</PIN>\n" +
                "            <FlagPINUsed>0</FlagPINUsed>\n" +
                "            <FlagPINForcing>0</FlagPINForcing>\n" +
                "          </PINInfo>\n" +
                "          <Gender>m</Gender>\n" +
                "          <BirthInfo>\n" +
                "            <DateOfBirth>10091992</DateOfBirth>\n" +
                "            <PlaceOfBirth>BROUMOV</PlaceOfBirth>\n" +
                "            <PlaceOfBirthForcing>0</PlaceOfBirthForcing>\n" +
                "            <CountryCode>CZ</CountryCode>\n" +
                "          </BirthInfo>\n" +
                "          <Address>\n" +
                "            <Place>\n" +
                "              <Street></Street>\n" +
                "              <ZIP></ZIP>\n" +
                "              <City></City>\n" +
                "              <Region></Region>\n" +
                "              <CountryCode></CountryCode>\n" +
                "            </Place>\n" +
                "          </Address>\n" +
                "          <AdditionalAddress>\n" +
                "            <Place>\n" +
                "              <Street></Street>\n" +
                "              <ZIP></ZIP>\n" +
                "              <City></City>\n" +
                "              <Region></Region>\n" +
                "              <CountryCode></CountryCode>\n" +
                "            </Place>\n" +
                "          </AdditionalAddress>\n" +
                "          <PhoneInfo>\n" +
                "            <PhoneNumber></PhoneNumber>\n" +
                "            <FaxNumber></FaxNumber>\n" +
                "            <MobilePhone></MobilePhone>\n" +
                "            <E-mail></E-mail>\n" +
                "            <AdditionalPhoneNumber></AdditionalPhoneNumber>\n" +
                "            <AdditionalFaxNumber></AdditionalFaxNumber>\n" +
                "          </PhoneInfo>\n" +
                "          <DocumentInfo>\n" +
                "            <DocumentType>3</DocumentType>\n" +
                "            <DocumentNumber>VS253005</DocumentNumber>\n" +
                "            <DocumentIssueDate>16072014</DocumentIssueDate>\n" +
                "            <DocumentExpirationDate></DocumentExpirationDate>\n" +
                "            <CountryCode>CZ</CountryCode>\n" +
                "          </DocumentInfo>\n" +
                "          <FlagElectronicSignatureHolder>0</FlagElectronicSignatureHolder>\n" +
                "        </Individual>\n" +
                "      </Customer>\n" +
                "      <ReplyTypeFlag>1</ReplyTypeFlag>\n" +
                "      <DetailOnResidenceRequestFlag>1</DetailOnResidenceRequestFlag>\n" +
                "      <DetailOnShareholderRequestFlag>1</DetailOnShareholderRequestFlag>\n" +
                "      <DetailOnRelatedNamesRequestFlag>1</DetailOnRelatedNamesRequestFlag>\n" +
                "      <DetailOnAdditionalPersonalRequestFlag>1</DetailOnAdditionalPersonalRequestFlag>\n" +
                "    </RI_REQ>]]>\n";

        return xml;
    }


    protected void process() throws Exception {

        // Create a StringEntity for the SOAP XML.
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <processSOAPReq xmlns=\"http://tempuri.org/\">\n" +
                "      <sRequest>\n" +
                    SoapRequestTest.payLoad() +
                "      </sRequest>\n" +
                "      <sResponse></sResponse>\n" +
                "    </processSOAPReq>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

        StringEntity stringEntity = new StringEntity(body);
        stringEntity.setChunked(true);
        System.out.println("=====================================================");
        System.out.println("body: " + body);
        System.out.println("=====================================================");


        HttpPost httpPost = new HttpPost("https://www.eurisczech.com/soaplistener/eurisczech.asmx");
        httpPost.setEntity(stringEntity);
        httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");
        httpPost.addHeader("SOAPAction", "http://tempuri.org/processSOAPReq");

        CloseableHttpClient httpClient = new CBCBHttpClient().create();


        try {
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("StatusCode: " + response.getStatusLine().getStatusCode());
            System.out.println("Response: " + response.toString());
            System.out.println("Entity: " + EntityUtils.toString(response.getEntity()));
            System.out.println("=====================================================");

        } finally {
            httpClient.close();
        }
    }

    public static void main(String[] args) throws Exception {

        SoapRequestTest soap = new SoapRequestTest();
        soap.process();

    }
}

