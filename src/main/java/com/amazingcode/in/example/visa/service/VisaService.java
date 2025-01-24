package com.amazingcode.in.example.visa.service;

import com.amazingcode.in.example.visa.external.request.ForexRateRequest;
import com.amazingcode.in.example.visa.external.response.ForexRateResponse;

public interface VisaService {
    ForexRateResponse changeCurrency(ForexRateRequest forexRateRequest);
}
