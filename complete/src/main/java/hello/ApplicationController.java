package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RestController
public class ApplicationController {
    @Autowired
    private RBCClient client = new RBCClient();

    @Autowired
    private WeatherClient weatherClient = new WeatherClient();

    @Autowired
    private PredictionClient predictionClient = new PredictionClient();

    @RequestMapping(value = "/rbc-server", method = RequestMethod.GET)
    public String run_rbc() {
        return client.calculateMaxRate();
    }

    @RequestMapping(value= "/weather-server", method = RequestMethod.GET)
    public String run_weather() throws IOException { return weatherClient.getCurrentForecast(); }

    @RequestMapping(value = "/pred-server", method = RequestMethod.GET)
    public String run_pred() throws IOException { return predictionClient.getWeatherPrediction(); }
}
