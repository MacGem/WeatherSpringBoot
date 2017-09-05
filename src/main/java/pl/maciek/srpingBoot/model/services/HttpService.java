package pl.maciek.srpingBoot.model.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by macie on 31.08.2017.
 */
public class HttpService {

    public HttpService(){

    }

    public String connectAndResponse(String url) throws IOException {
        // do zapiasnia calego ciagu bitow pobranych ze strony
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        //buffr ala youtube = pobiera dane do przodu
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getResponseCode()==200 ? connection.getInputStream() : connection.getErrorStream()
        ));
        //odczytywanie linia po lini z buffera
        String line = "";
        while((line = reader.readLine()) !=null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
