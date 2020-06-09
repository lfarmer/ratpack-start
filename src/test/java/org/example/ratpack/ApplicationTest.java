package org.example.ratpack;

import org.junit.Test;
import ratpack.http.client.ReceivedResponse;
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
}
