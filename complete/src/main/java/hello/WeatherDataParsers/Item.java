package hello.WeatherDataParsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    public int time;
    public Double temperature;
}
