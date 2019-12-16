package hello.DataBase.Repos;

import hello.DataBase.Objects.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  WeatherRepo extends CrudRepository<Weather, Long> {

    Optional<Weather> getTempById(Long num);
    Optional<Weather> findByTime(long value);
}
