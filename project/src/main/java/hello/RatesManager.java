package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Arrays;

@SpringBootApplication
public class RatesManager {

    public void main(String[] args) {
        String[] rows = getData("30");
        double[] obtained_rates = parseRates(rows);
        double max = getMaxRate(obtained_rates);
        System.out.println(String.format("\nMax rate for the last month: %f\n", max));
    }

    public String[] getData(String period) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://export.rbc.ru/free/selt.0/free.fcgi?period=DAILY&tickers=USD000000TOD&separator=,&data_format=BROWSER&lastdays=" + period, String.class);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        return Objects.requireNonNull(response.getBody()).split("\n");
    }

    public double[] parseRates(String[] string_data) {
        double[] rates = new double[string_data.length];
        for (int i = 0; i < string_data.length; i++) {
            String[] cur_string_data = string_data[i].split(",");
            rates[i] = Double.parseDouble(cur_string_data[cur_string_data.length -1]);
        }
        return rates;
    }

    public double getMaxRate(double[] rates) {
        Arrays.sort(rates);

        return rates[rates.length-1];
    }

}


