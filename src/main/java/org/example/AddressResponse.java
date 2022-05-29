package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Address {
    public final Integer user_id;
    public final String address;
    public final String label;
    public final String pending_received_balance;
    public final String available_balance;
    public final Boolean is_segwit;

    public Address(
            @JsonProperty("user_id") Integer user_id,
            @JsonProperty("address") String address,
            @JsonProperty("label") String label,
            @JsonProperty("pending_received_balance") String pending_received_balance,
            @JsonProperty("available_balance") String available_balance,
            @JsonProperty("is_segwit") Boolean is_segwit

    ) {
        this.user_id = user_id;
        this.address = address;
        this.label = label;
        this.pending_received_balance = pending_received_balance;
        this.available_balance = available_balance;
        this.is_segwit = is_segwit;
    }
}

class AddressResponseData {
    public final String network;
    public final List<Address> addresses;
    public final Integer page;
    public final Boolean has_more;

    AddressResponseData(
            @JsonProperty("network")  String network,
            @JsonProperty("addresses") List<Address> addresses,
            @JsonProperty("page")  Integer page,
            @JsonProperty("has_more")  Boolean has_more
    ) {
        this.network = network;
        this.addresses = addresses;
        this.page = page;
        this.has_more = has_more;
    }
}

public class AddressResponse {
    public final String status;
    public final AddressResponseData data;


    public AddressResponse(
            @JsonProperty("status")  String status,
            @JsonProperty("data")  AddressResponseData data
    ) {
        this.status = status;
        this.data = data;
    }
}
