package com.example.main.models;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"forecast_weather",
"todays_weather"
})
public class Example {

@JsonProperty("forecast_weather")
private ForecastWeather forecastWeather;
@JsonProperty("todays_weather")
private TodaysWeather todaysWeather;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("forecast_weather")
public ForecastWeather getForecastWeather() {
return forecastWeather;
}

@JsonProperty("forecast_weather")
public void setForecastWeather(ForecastWeather forecastWeather) {
this.forecastWeather = forecastWeather;
}

@JsonProperty("todays_weather")
public TodaysWeather getTodaysWeather() {
return todaysWeather;
}

@JsonProperty("todays_weather")
public void setTodaysWeather(TodaysWeather todaysWeather) {
this.todaysWeather = todaysWeather;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
