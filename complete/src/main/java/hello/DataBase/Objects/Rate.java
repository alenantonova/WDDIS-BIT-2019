package hello.DataBase.Objects;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name="APPLICATION_RATES")
@Entity
public class Rate {
    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Id
    @Column(name ="RATE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String date;
    private Double value;

    public Rate(Date init_date, Double init_value) {
        System.out.println(init_date);
        date = dateFormat.format(init_date);
        System.out.println(date);
        value = init_value;
    }

    protected Rate() {}

    public String getDate() {return date;}
    public Double getRate() {return value;}
    public static String toDateFormat(Date date) {return dateFormat.format(date);}
}
