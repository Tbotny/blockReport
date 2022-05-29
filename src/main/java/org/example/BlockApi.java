package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BlockApi {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final OkHttpClient client = new OkHttpClient();
    private final HttpUrl addressesUrl;

    public BlockApi(String apiKey) {
        this.addressesUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("block.io")
                .addPathSegments("api/v2/get_my_addresses")
                .addQueryParameter("api_key", apiKey)
                .build();
    }

    public AddressResponse getAddresses() {
        try {
            Request request = new Request.Builder()
                    .url(addressesUrl)
                    .build();

            Response response = client
                    .newCall(request)
                    .execute();

            assert response.body() != null;
            return mapper.readValue(
                    response.body().byteStream(),
                    AddressResponse.class
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
