
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

class CBCBHttpClient {

    CloseableHttpClient create()
            throws KeyStoreException, CertificateException, NoSuchAlgorithmException,
            IOException, UnrecoverableKeyException, KeyManagementException {

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);

        trustStore.setCertificateEntry("ca", CertificateFactory.getInstance("X.509")
                .generateCertificate(getClass().getClassLoader().getResourceAsStream("cert_ca.cer")));

        TrustManagerFactory certManagerFactory = TrustManagerFactory.getInstance("SunX509");
        certManagerFactory.init(trustStore);

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(getClass().getClassLoader().getResourceAsStream("Private.pfx"), "Kreditech2017".toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, "Kreditech2017".toCharArray());

        // create context
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(keyManagerFactory.getKeyManagers(), certManagerFactory.getTrustManagers(), new SecureRandom());

        return HttpClients.custom().setSSLContext(context).build();
    }

}
