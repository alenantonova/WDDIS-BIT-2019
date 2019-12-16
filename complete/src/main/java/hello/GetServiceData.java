package hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetServiceData {
    String rates;
    String temperature;

    public void takeRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://export.rbc.ru/free/selt.0/free.fcgi?period=DAILY&tickers=USD000000TOD&separator=,&data_format=BROWSER&lastdays=30", String.class);
        this.rates = response.getBody();
    }

    public void takeWeather(String request_date) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.darksky.net/forecast/7680422f32effb534f62f1283f0c38be/42.3601,-71.0589," + request_date, String.class);
        this.temperature = response.getBody();
    }

    public String getRates() {return rates;}
    public String getTemperature() {return temperature;}
}
