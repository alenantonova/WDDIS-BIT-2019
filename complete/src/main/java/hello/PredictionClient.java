package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class PredictionClient {
    @Autowired private RBCClient rbcClient;
    @Autowired private WeatherClient weatherClient;

    public String getWeatherPrediction() throws IOException {
        List<Double> rates = Arrays.asList(rbcClient.getAllRates());
        Collections.reverse(rates);
        List<Double> weather = weatherClient.getAllTemperature().subList(0, rates.size());
        Double temp_sum = 0.0;
        Double squared_temp_sum = 0.0;
        Double rates_sum = 0.0;

        for (int i = 0; i < rates.size(); ++i) {
            temp_sum += weather.get(i);
            squared_temp_sum += weather.get(i) * weather.get(i);
            rates_sum += rates.get(i);
        }

        Double sum = 0.0;
        for (int i = 0; i < rates.size(); i++) {
            sum += weather.get(i) * rates.get(i);
        }

        Double a = 0.0;
        Double b = 0.0;

        if (weather.size() != 0) {
            a = (rates_sum - b * temp_sum) / weather.size();
        }
        if (weather.size() * squared_temp_sum - temp_sum * temp_sum != 0 ) {
            b = (weather.size() * sum - temp_sum * rates_sum) / (weather.size() * squared_temp_sum - temp_sum * temp_sum);
        }

        return "Predicted value is : " + Double.toString(a + b *  weatherClient.getCurrentWeather());

    }
}
