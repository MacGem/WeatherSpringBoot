package pl.maciek.srpingBoot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by macie on 01.09.2017.
 */
public class Appli {

    private static final Logger log = LoggerFactory.getLogger(Appli.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherInfo quote = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather", WeatherInfo.class);
        log.info(quote.toString());
    }

}
