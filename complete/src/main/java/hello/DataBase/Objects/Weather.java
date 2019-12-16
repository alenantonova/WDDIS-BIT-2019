package hello.DataBase.Objects;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "APPLICATION_WEATHER")
@Entity
public class Weather {

    @Id
    @Column(name = "WEATHER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private long time;
    private Double temperature;

    public Weather(long init_time, Double init_temperature) {
        time = init_time;
        temperature = init_temperature;
    }

    public long getTime() {return time;}
    public Double getTemperature() {return temperature;}
}
