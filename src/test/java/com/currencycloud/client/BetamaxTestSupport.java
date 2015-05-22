package com.currencycloud.client;

import co.freeside.betamax.ProxyConfiguration;
import co.freeside.betamax.TapeMode;
import co.freeside.betamax.junit.RecorderRule;
import org.junit.Rule;

import java.io.File;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.io.FileMatchers.anExistingDirectory;

public class BetamaxTestSupport extends JsonTestSupport {

    @Rule
    public RecorderRule createRecorder() {
        String tc = this.getClass().getSimpleName();
        File tapeRoot = new File("src/test/resources/betamax/tapes/", (tc).substring(0, tc.length() - "Test".length()));
        assertThat(tapeRoot, is(anExistingDirectory()));

        return new RecorderRule(ProxyConfiguration.builder()
                                        .tapeRoot(tapeRoot)
                                        .proxyPort(5555)
                                        .proxyTimeoutSeconds(3)
                                        .defaultMode(TapeMode.READ_ONLY)
                                        .ignoreHosts(Collections.<String>emptyList())
                                        .ignoreLocalhost(false)
                                        .sslEnabled(true)
                                        .build());
    }

    protected CurrencyCloudClient prepareTestClient(String loginId, String apiKey, String authToken) {
        CurrencyCloudClient client = new CurrencyCloudClient("http://localhost:5555", loginId, apiKey);
        client.setAuthToken(authToken);
        return client;
    }
}
