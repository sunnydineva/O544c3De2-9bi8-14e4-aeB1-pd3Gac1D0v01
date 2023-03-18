# Covid Stats Service
# O544c3De2-9bi8-14e4-aeB1-pd3Gac1D0v01

This is a Spring Boot microservice that provides COVID-19 statistics for countries around the world.

## Building the Service

To build the service, you will need to have Java and Maven installed on your machine. You can follow the installation guides for [Java](https://www.java.com/en/download/help/download_options.html) and [Maven](https://maven.apache.org/install.html).

Once you have Java and Maven installed, clone the repository and navigate to the project root directory:

git clone https://github.com/your-username/covid-stats-service.git


## Starting the Service
To start the service, run the following command:

java -jar target/covid-stats-service.jar

This will start the service on port 8080.

## Accessing the Service

To access the service, open a web browser and navigate to `http://localhost:8080/country/{countryCode}`, where `{countryCode}` is the 2-letter code for the country you are interested in. For example, to get COVID-19 statistics for Bulgaria, you would navigate to `http://localhost:8080/country/BG`.

The service returns a JSON object containing the COVID-19 statistics for the specified country. Here's an example:

```json
{
  "country": "Bulgaria",
  "countryCode": "BG",
  "totalConfirmed": 100000,
  "newConfirmed": 5000,
  "totalDeaths": 5000,
  "newDeaths": 200,
  "totalRecovered": 75000,
  "newRecovered": 3000,
  "date": "2023-03-18T00:00:00Z"
} 
```

That's it! You should now be able to build, start, and access the Covid Stats Service.

## Author
The project is developed by Sunny Dineva
`https://www.linkedin.com/in/sunny-dineva`
