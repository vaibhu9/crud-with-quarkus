package com.amazingcode.in.example.employee.external.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.amazingcode.in.example.employee.external.response.UserResponse;
import com.amazingcode.in.example.visa.external.request.ForexRateRequest;
import com.amazingcode.in.example.visa.external.response.ForexRateResponse;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

// @RegisterRestClient(baseUri = "https://dummyjson.com")
@RegisterRestClient(baseUri = "https://sandbox.api.visa.com")
public interface UserServiceClient {

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    UserResponse getUsers();

    // @POST
    // @Path("")
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // ForexRateResponse changeCurrency(ForexRateRequest forexRateRequest);

    @POST
    @Path("/forexrates/v2/foreignexchangerates")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ForexRateResponse changeCurrency(ForexRateRequest forexRateRequest);
}
