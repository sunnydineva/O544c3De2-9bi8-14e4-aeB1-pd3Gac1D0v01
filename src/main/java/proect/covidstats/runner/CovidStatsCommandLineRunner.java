package proect.covidstats.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.json.*;
import proect.covidstats.entity.Country;
import proect.covidstats.entity.CovidData;
import proect.covidstats.entity.Global;
import proect.covidstats.repository.CountryRepository;
import proect.covidstats.repository.CovidDataRepository;
import proect.covidstats.repository.GlobalRepository;
import java.time.Instant;
import java.util.UUID;

@Component
public class CovidStatsCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private GlobalRepository globalRepository;
    @Autowired
    private CovidDataRepository covidDataRepository;

    @Override
    public void run(String... args) throws Exception {

        String apiUrl = "https://api.covid19api.com/summary";
        System.out.println(apiUrl);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(apiUrl, String.class);

        JSONObject json = new JSONObject(result);
        JSONObject globalJson = json.getJSONObject("Global");
        JSONArray countriesJson = json.getJSONArray("Countries");

        //Save covid data
        CovidData data = CovidData.builder()
                .ID(json.getString("ID"))
                .message(json.getString("Message"))
                .build();
        covidDataRepository.save(data);

        // Save global data
        Global global = Global.builder()
                .newConfirmed(globalJson.getInt("NewConfirmed"))
                .totalConfirmed(globalJson.getLong("TotalConfirmed"))
                .newDeaths(globalJson.getInt("NewDeaths"))
                .totalDeaths(globalJson.getLong("TotalDeaths"))
                .newRecovered(globalJson.getInt("NewRecovered"))
                .totalRecovered(globalJson.getLong("TotalRecovered"))
                .date(Instant.parse(globalJson.getString("Date")))
                .build();
        globalRepository.save(global);

        // Save country data
        for (int i = 0; i < countriesJson.length(); i++) {
            JSONObject countryJson = countriesJson.getJSONObject(i);
            Country country = Country.builder()
                    .ID(UUID.fromString(countryJson.getString("ID")))
                    .country(countryJson.getString("Country"))
                    .countryCode(countryJson.getString("CountryCode"))
                    .slug(countryJson.getString("Slug"))
                    .newConfirmed(countryJson.getInt("NewConfirmed"))
                    .totalConfirmed(countryJson.getLong("TotalConfirmed"))
                    .newDeaths(countryJson.getInt("NewDeaths"))
                    .totalDeaths(countryJson.getLong("TotalDeaths"))
                    .newRecovered(countryJson.getInt("NewRecovered"))
                    .totalRecovered(countryJson.getLong("TotalRecovered"))
                    .date(Instant.parse(countryJson.getString("Date")))
                    .build();
            countryRepository.save(country);
        }
    }
}




