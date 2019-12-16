package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.DataBase.Objects.Rate;
import hello.DataBase.Repos.RateRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Component
public class RBCClient {

    @Autowired
    private RateRepo applicationRepo;

    @Transactional
    public void addMaxRateToBase(Double rate) {
        Date date = Calendar.getInstance().getTime();
        Rate maxRate = new Rate(date, rate);
        applicationRepo.save(maxRate);
    }

    public String[] splitData(String response) {
        return response.split("\n");
    }


    public Double[] parseRates(String[] string_data) {
        Double[] rates = new Double[string_data.length];
        for (int i = 0; i < string_data.length; i++) {
            String[] cur_string_data = string_data[i].split(",");
            rates[i] = Double.parseDouble(cur_string_data[cur_string_data.length -1]);
        }
        return rates;
    }

    @Transactional
    public double getMaxRate(Double[] rates) {
        Date cur_date = Calendar.getInstance().getTime();
        Optional<Rate> rate = applicationRepo.findByDate(Rate.toDateFormat(cur_date));
        if (rate.isPresent()) {
            System.out.println("Max rate was found in DB\n");
            return (rate.map(Rate::getRate)).get();
        } else {
            Arrays.sort(rates);
            System.out.println("Add max rate to DB\n");
            addMaxRateToBase(rates[rates.length - 1]);
            return rates[rates.length - 1];
        }
    }

    public Double[] getAllRates() {
        GetServiceData getter = new GetServiceData();
        getter.takeRates();
        String[] rows = splitData(getter.rates);
        return parseRates(rows);
    }

    public String calculateMaxRate() {
        Double[] obtained_rates = getAllRates();
        double max = getMaxRate(obtained_rates);
        return ("\nMax rate for the last month: \n" + max);
    }

}



