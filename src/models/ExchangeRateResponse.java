package models;

import java.util.Map;

public record ExchangeRateResponse(double conversion_rate, Map<String, String> supported_codes) {}

