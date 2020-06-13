package org.example.ratpack;

import org.junit.Test;
import ratpack.func.Action;
import ratpack.http.MutableHeaders;
import ratpack.http.Status;
import ratpack.http.client.ReceivedResponse;
import ratpack.http.client.RequestSpec;
import ratpack.test.MainClassApplicationUnderTest;

import static org.assertj.core.api.Assertions.assertThat;


public class ApplicationTest {

    MainClassApplicationUnderTest application
            = new MainClassApplicationUnderTest(Application.class);

    @Test
    public void shouldReturnRatpackMessageAtContextRoot() {
        // When
        ReceivedResponse response = application.getHttpClient().get("/");

        // Then
        assertThat(response.getBody().getText()).isEqualTo("Ratpack is a GO!!!");
    }

    @Test
    public void shouldReturnAllowOriginForLocalhost() {
        // When
        ReceivedResponse response = application.getHttpClient().get("/");

        // Then
        assertThat(response.getHeaders().get("Access-Control-Allow-Origin"))
                .isEqualTo("http://localhost");
    }

    @Test
    public void shouldSetAllowOriginHeaders() {
        // When
        ReceivedResponse response = application.getHttpClient().get("/");

        // Then
        assertThat(response.getHeaders().get("Access-Control-Allow-Headers"))
                .isEqualTo("x-requested-with, origin, content-type, accept");
    }
}
