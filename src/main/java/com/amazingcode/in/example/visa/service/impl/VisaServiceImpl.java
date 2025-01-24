package com.amazingcode.in.example.visa.service.impl;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.amazingcode.in.example.visa.external.client.VisaServiceClient;
import com.amazingcode.in.example.visa.external.exception.ChangeCurrencyException;
import com.amazingcode.in.example.visa.external.request.ForexRateRequest;
import com.amazingcode.in.example.visa.external.response.ForexRateResponse;
import com.amazingcode.in.example.visa.external.ssl.ClientBuilderUtil;
import com.amazingcode.in.example.visa.external.ssl.SSLContextProducer;
import com.amazingcode.in.example.visa.service.VisaService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VisaServiceImpl implements VisaService {

    @RestClient
    private final VisaServiceClient visaServiceClient;

    @Inject
    public VisaServiceImpl(SSLContextProducer sslContextProducer){
        this.visaServiceClient = ClientBuilderUtil.createVisaServiceClient(sslContextProducer.produceSSLContext());
    }

    @Override
    public ForexRateResponse changeCurrency(ForexRateRequest forexRateRequest) {
        try {
            return visaServiceClient.changeCurrency(forexRateRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ChangeCurrencyException("Failed to convert currency."+e.getMessage());
        }
    }
}
