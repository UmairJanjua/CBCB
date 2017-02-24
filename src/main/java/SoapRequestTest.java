import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

class SoapRequestTest {


    public static void getResponse(String xml) throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xml));
        Document doc = builder.parse(src);
        String response = doc.getElementsByTagName("sResponse").item(0).getTextContent();
        System.out.println("response: " + response);

    }

    public static String payLoad(){

        String xml = "      \t<![CDATA[<RI_REQ xsi:noNamespaceSchemaLocation=\"RI_REQ_schema.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "\t\t\t<TecData>\n" +
                "\t\t\t\t<UserId>L0045001</UserId>\n" +
                "\t\t\t\t<Password>k9F3BgXy</Password>\n" +
                "\t\t\t</TecData>\n" +
                "\t\t\t<Header>\n" +
                "\t\t\t\t<FunctionCode>01001</FunctionCode>\n" +
                "\t\t\t\t<ReleaseOfFunctionCode>1</ReleaseOfFunctionCode>\n" +
                "\t\t\t\t<Service>EB</Service>\n" +
                "\t\t\t</Header>\n" +
                "\t\t\t<ContractData>\n" +
                "\t\t\t\t<FlagAllowedToExchange>1</FlagAllowedToExchange>\n" +
                "\t\t\t\t<OpNumber></OpNumber>\n" +
                "\t\t\t\t<FinancingRequestDate>10042015</FinancingRequestDate>\n" +
                "\t\t\t\t<OpPhase>ZD</OpPhase>\n" +
                "\t\t\t\t<OpType>FL</OpType>\n" +
                "\t\t\t\t<NrOfInstalments>12</NrOfInstalments>\n" +
                "\t\t\t\t<Periodicity>M</Periodicity>\n" +
                "\t\t\t\t<MethodOfPayment></MethodOfPayment>\n" +
                "\t\t\t\t<FinancedCapital-Credit>100000</FinancedCapital-Credit>\n" +
                "\t\t\t\t<MonthlyInstalmentAmount></MonthlyInstalmentAmount>\n" +
                "\t\t\t\t<CurrencyCode>CZK</CurrencyCode>\n" +
                "\t\t\t\t<ChannelType>1</ChannelType>\n" +
                "\t\t\t</ContractData>\n" +
                "\t\t\t<AdditionalServices>\n" +
                "\t\t\t\t<AdditionalScores>\n" +
                "\t\t\t\t\t<ScoreModelId>FSI</ScoreModelId>\n" +
                "\t\t\t\t</AdditionalScores>\n" +
                "\t\t\t\t<IdCheck>0</IdCheck>\n" +
                "\t\t\t</AdditionalServices>\n" +
                "\t\t\t<CustomerType>1</CustomerType>\n" +
                "\t\t\t<Customer>\n" +
                "\t\t\t\t<FIPersonalCode></FIPersonalCode>\n" +
                "\t\t\t\t<RoleCode>A</RoleCode>\n" +
                "\t\t\t\t<Individual>\n" +
                "\t\t\t\t\t<Name>\n" +
                "\t\t\t\t\t\t<PresentSurname-TradeName>NEKONEČNÁ</PresentSurname-TradeName>\n" +
                "\t\t\t\t\t\t<PresentName-OwnerPresentName>JARMILA</PresentName-OwnerPresentName>\n" +
                "\t\t\t\t\t\t<NameForcing>0</NameForcing>\n" +
                "\t\t\t\t\t\t<PresentSurnameForcing>0</PresentSurnameForcing>\n" +
                "\t\t\t\t\t\t<OwnerPresentSurname>NEKONEČNÁ</OwnerPresentSurname>\n" +
                "\t\t\t\t\t\t<BirthSurname>RYCHLÁ</BirthSurname>\n" +
                "\t\t\t\t\t\t<BirthSurnameForcing>0</BirthSurnameForcing>\n" +
                "\t\t\t\t\t</Name>\n" +
                "\t\t\t\t\t<PINInfo>\n" +
                "\t\t\t\t\t\t<PIN>756015/0125</PIN>\n" +
                "\t\t\t\t\t\t<FlagPINUsed>0</FlagPINUsed>\n" +
                "\t\t\t\t\t\t<FlagPINForcing>0</FlagPINForcing>\n" +
                "\t\t\t\t\t</PINInfo>\n" +
                "\t\t\t\t\t<Gender>Z</Gender>\n" +
                "\t\t\t\t\t<BirthInfo>\n" +
                "\t\t\t\t\t\t<DateOfBirth>15101975</DateOfBirth>\n" +
                "\t\t\t\t\t\t<PlaceOfBirth>BROUMOV</PlaceOfBirth>\n" +
                "\t\t\t\t\t\t<PlaceOfBirthForcing>0</PlaceOfBirthForcing>\n" +
                "\t\t\t\t\t\t<CountryCode>CZ</CountryCode>\n" +
                "\t\t\t\t\t</BirthInfo>\n" +
                "\t\t\t\t\t<Address>\n" +
                "\t\t\t\t\t\t<Place>\n" +
                "\t\t\t\t\t\t\t<Street></Street>\n" +
                "\t\t\t\t\t\t\t<ZIP></ZIP>\n" +
                "\t\t\t\t\t\t\t<City></City>\n" +
                "\t\t\t\t\t\t\t<Region></Region>\n" +
                "\t\t\t\t\t\t\t<CountryCode></CountryCode>\n" +
                "\t\t\t\t\t\t</Place>\n" +
                "\t\t\t\t\t</Address>\n" +
                "\t\t\t\t\t<AdditionalAddress>\n" +
                "\t\t\t\t\t\t<Place>\n" +
                "\t\t\t\t\t\t\t<Street></Street>\n" +
                "\t\t\t\t\t\t\t<ZIP></ZIP>\n" +
                "\t\t\t\t\t\t\t<City></City>\n" +
                "\t\t\t\t\t\t\t<Region></Region>\n" +
                "\t\t\t\t\t\t\t<CountryCode></CountryCode>\n" +
                "\t\t\t\t\t\t</Place>\n" +
                "\t\t\t\t\t</AdditionalAddress>\n" +
                "\t\t\t\t\t<PhoneInfo>\n" +
                "\t\t\t\t\t\t<PhoneNumber></PhoneNumber>\n" +
                "\t\t\t\t\t\t<FaxNumber></FaxNumber>\n" +
                "\t\t\t\t\t\t<MobilePhone></MobilePhone>\n" +
                "\t\t\t\t\t\t<E-mail></E-mail>\n" +
                "\t\t\t\t\t\t<AdditionalPhoneNumber></AdditionalPhoneNumber>\n" +
                "\t\t\t\t\t\t<AdditionalFaxNumber></AdditionalFaxNumber>\n" +
                "\t\t\t\t\t</PhoneInfo>\n" +
                "\t\t\t\t\t<DocumentInfo>\n" +
                "\t\t\t\t\t\t<DocumentType>3</DocumentType>\n" +
                "\t\t\t\t\t\t<DocumentNumber>VS253005</DocumentNumber>\n" +
                "\t\t\t\t\t\t<DocumentIssueDate>16072014</DocumentIssueDate>\n" +
                "\t\t\t\t\t\t<DocumentExpirationDate></DocumentExpirationDate>\n" +
                "\t\t\t\t\t\t<CountryCode>CZ</CountryCode>\n" +
                "\t\t\t\t\t</DocumentInfo>\n" +
                "\t\t\t\t\t<FlagElectronicSignatureHolder>0</FlagElectronicSignatureHolder>\n" +
                "\t\t\t\t</Individual>\n" +
                "\t\t\t</Customer>\n" +
                "\t\t\t<ReplyTypeFlag>1</ReplyTypeFlag>\n" +
                "\t\t\t<DetailOnResidenceRequestFlag>1</DetailOnResidenceRequestFlag>\n" +
                "\t\t\t<DetailOnShareholderRequestFlag>1</DetailOnShareholderRequestFlag>\n" +
                "\t\t\t<DetailOnRelatedNamesRequestFlag>1</DetailOnRelatedNamesRequestFlag>\n" +
                "\t\t\t<DetailOnAdditionalPersonalRequestFlag>1</DetailOnAdditionalPersonalRequestFlag>\n" +
                "\t\t</RI_REQ>]]>";


        return xml;
    }


    protected void process() throws Exception {

        // Create a StringEntity for the SOAP XML.
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <processSOAPReq xmlns=\"http://tempuri.org/\">\n" +
                "      <sRequest>" +
                         SoapRequestTest.payLoad() +
                "      </sRequest>\n" +
                "    </processSOAPReq>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>\n";


        StringEntity stringEntity = new StringEntity(body);
        stringEntity.setChunked(true);
//        System.out.println("body: " + body);

        HttpPost httpPost = new HttpPost("https://www.eurisczechtest.com/soaplistener/eurisczech.asmx");
        httpPost.setEntity(stringEntity);
        httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");
        httpPost.addHeader("SOAPAction", "http://tempuri.org/processSOAPReq");

        CloseableHttpClient httpClient = new CBCBHttpClient().create();


        try {
            HttpResponse response = httpClient.execute(httpPost);
//            System.out.println("StatusCode: " + response.getStatusLine().getStatusCode());
//            System.out.println("Response: " + response.toString());
            String finalResponse = EntityUtils.toString(response.getEntity());
//            System.out.println("Entity: " + finalResponse);
            System.out.println("=====================================================");
            getResponse(finalResponse);

        } finally {
            httpClient.close();
        }
    }

    public static void main(String[] args) throws Exception {

        SoapRequestTest soap = new SoapRequestTest();
        soap.process();

    }
}

