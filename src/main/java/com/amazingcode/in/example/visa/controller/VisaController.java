package com.amazingcode.in.example.visa.controller;

import com.amazingcode.in.example.visa.external.request.ForexRateRequest;
import com.amazingcode.in.example.visa.external.response.ForexRateResponse;
import com.amazingcode.in.example.visa.service.VisaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/visa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VisaController {
    
    private final VisaService visaService;

    @Inject
    public VisaController(VisaService visaService){
        this.visaService = visaService;
    }

    @POST
    @Path("/convert-currency")
    public Response changeCurrency(ForexRateRequest forexRateRequest) {
        ForexRateResponse response = visaService.changeCurrency(forexRateRequest);
        return Response.ok(response).build();
    }
}
