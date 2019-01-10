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
"temp",
"pressure",
"humidity",
"temp_min",
"temp_max",
"sea_level",
"grnd_level",
"main",
"description"
})
public class Today {

@JsonProperty("temp")
private Double temp;
@JsonProperty("pressure")
private Double pressure;
@JsonProperty("humidity")
private Integer humidity;
@JsonProperty("temp_min")
private Double tempMin;
@JsonProperty("temp_max")
private Double tempMax;
@JsonProperty("sea_level")
private Double seaLevel;
@JsonProperty("grnd_level")
private Double grndLevel;
@JsonProperty("main")
private String main;
@JsonProperty("description")
private String description;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("temp")
public Double getTemp() {
return temp;
}

@JsonProperty("temp")
public void setTemp(Double temp) {
this.temp = temp;
}

@JsonProperty("pressure")
public Double getPressure() {
return pressure;
}

@JsonProperty("pressure")
public void setPressure(Double pressure) {
this.pressure = pressure;
}

@JsonProperty("humidity")
public Integer getHumidity() {
return humidity;
}

@JsonProperty("humidity")
public void setHumidity(Integer humidity) {
this.humidity = humidity;
}

@JsonProperty("temp_min")
public Double getTempMin() {
return tempMin;
}

@JsonProperty("temp_min")
public void setTempMin(Double tempMin) {
this.tempMin = tempMin;
}

@JsonProperty("temp_max")
public Double getTempMax() {
return tempMax;
}

@JsonProperty("temp_max")
public void setTempMax(Double tempMax) {
this.tempMax = tempMax;
}

@JsonProperty("sea_level")
public Double getSeaLevel() {
return seaLevel;
}

@JsonProperty("sea_level")
public void setSeaLevel(Double seaLevel) {
this.seaLevel = seaLevel;
}

@JsonProperty("grnd_level")
public Double getGrndLevel() {
return grndLevel;
}

@JsonProperty("grnd_level")
public void setGrndLevel(Double grndLevel) {
this.grndLevel = grndLevel;
}

@JsonProperty("main")
public String getMain() {
return main;
}

@JsonProperty("main")
public void setMain(String main) {
this.main = main;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
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