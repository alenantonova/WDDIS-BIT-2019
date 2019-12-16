package hello.WeatherDataParsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentlyData {
    public Double temperature;
}
