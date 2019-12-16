package hello.WeatherDataParsers;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyData {
    public Item[] data;
}
