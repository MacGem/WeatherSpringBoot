package pl.maciek.srpingBoot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.maciek.srpingBoot.jsonweather.WeatherInfo;

import static pl.maciek.srpingBoot.model.Config.APP_ID;

/**
 * Created by macie on 01.09.2017.
 */
@Service
public class Appli {

    private static final Logger log = LoggerFactory.getLogger(Appli.class);

    public static void main(String args[]) {

        Appli appli = new Appli();
        WeatherInfo weatherInfo = appli.backWeather("london");
        System.out.println(weatherInfo.toString());
    }

    public WeatherInfo backWeather (String findCity) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(Config.APP_URL)
                // Add query parameter
                .queryParam("q", findCity)
                .queryParam("appid", Config.APP_ID);

        RestTemplate restTemplate = new RestTemplate();
        WeatherInfo quote = restTemplate.getForObject(builder.build().encode().toUri(), WeatherInfo.class);
        log.info(quote.toString());
        return quote;
    }

}
