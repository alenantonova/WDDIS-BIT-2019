package hello.WeatherDataParsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    public DailyData daily;
    public CurrentlyData currently;
}
