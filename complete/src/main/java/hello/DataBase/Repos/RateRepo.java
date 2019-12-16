package hello.DataBase.Repos;

import hello.DataBase.Objects.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  RateRepo extends CrudRepository<Rate, Long> {

    Optional<Rate> getRateById(Long num);
    Optional<Rate> findByDate(String value);
}
