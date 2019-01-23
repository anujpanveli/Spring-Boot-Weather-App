package com.example.main.services;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.example.main.models.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService extends MappingJackson2HttpMessageConverter   {

    private static WeatherService ourInstance = new WeatherService();
       
    public static WeatherService getInstance() {
        return ourInstance;
    }

    private WeatherService() {
    	setPrettyPrint(true);
    }

    public List<Example> getWeatherForFive(String city) throws ParseException {
       
    	String websiteResponse = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=json&appid="+Place Your Api Key Here+"&units=metric";
    	
    	RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);	    	   	    	        
        
        String description = null;
        double temp=0;
        int pressure=0;
        int humidity = 0;
        int temp_min=0;
        int temp_max=0;
        int temp_kf=0;
        int sea_level=0;
        int grnd_level=0;
        
        java.util.Date date1 = null;
        
        String date = null;
       
        String icon=null;
        String WeatherCondition=null;
        int id=0;
        
        List<Example> weatherList = new ArrayList<>();

        JSONObject root = new JSONObject(result);

        SimpleDateFormat dfoutput2 = new SimpleDateFormat("HH");
        SimpleDateFormat dfoutput1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dfinput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        JSONArray weatherObject = root.getJSONArray("list");

        for(int i = 0; i < weatherObject.length(); i++) {
              	
            JSONObject arrayElement = weatherObject.getJSONObject(i);
            
            JSONObject main = arrayElement.getJSONObject("main");
            temp = (int) main.getFloat("temp");
            pressure =  main.getInt("pressure");
            humidity = main.getInt("humidity");
            temp_min = main.getInt("temp_min");
            temp_max = main.getInt("temp_max");
            temp_kf = main.getInt("temp_kf");
            sea_level = main.getInt("sea_level");
            grnd_level = main.getInt("grnd_level");
            
            description = arrayElement.getJSONArray("weather").getJSONObject(0).getString("description");
            icon = arrayElement.getJSONArray("weather").getJSONObject(0).getString("icon");
            WeatherCondition = arrayElement.getJSONArray("weather").getJSONObject(0).getString("main");
            id = arrayElement.getJSONArray("weather").getJSONObject(0).getInt("id");
                     
                   date = arrayElement.getString("dt_txt");
            	
                   date1 = dfinput.parse(date);
                  
                   
                 ForecastWeather fw=new ForecastWeather();
                 Date dt=new Date();
                 Main mn=new Main();
                 Example e = new Example();
                
                 Time t = new Time();
                 Weather w = new Weather();
                 
           
                   mn.setTemp(temp);
                   mn.setPressure((int) pressure/10);
                   mn.setHumidity(humidity);
                   mn.setGrndLevel(grnd_level);
                   mn.setSeaLevel(sea_level);
                   mn.setTempKf(temp_kf);
                 
                   mn.setTempMax(temp_max);
                   mn.setTempMin(temp_min);
                 
                   w.setDescription(description);
                   w.setIcon(icon);
                   w.setId(id);
                   w.setMain(WeatherCondition);
                 
                   t.setTime(dfoutput2.format(date1));
                   t.setMain(mn);
                   t.setWeather(w);
                                                                                        
                   dt.setAdditionalProperty(dfoutput2.format(date1), t);
                   
                   fw.setAdditionalProperty(dfoutput1.format(date1), dt);
                  							                                				                                
                   e.setForecastWeather(fw);
                   
                weatherList.add(e);              
           }
    
        return weatherList;
    }

    
    public List<Example> getWeather(String city) {
   
String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?q="+ city + "&mode=json&appid=+"Type your app id here"+&units=metric";
    	
    	RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);	 
    	
        String description = null;
        String WeatherCondition = null;
        double temp;
        double temp_min;
        double temp_max;
        double pressure;
        int humidity;
       
        
        List<Example> weatherList = new ArrayList<>();
              
        JSONObject root = new JSONObject(result);

        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
            WeatherCondition = elementInArray.getString("main");
        }

        JSONObject main = root.getJSONObject("main");
       
        temp = (int) main.getFloat("temp");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");
        temp_min= (int) main.getFloat("temp_min");
        temp_max= (int) main.getFloat("temp_max");
        
 
        
            TodaysWeather tw=new TodaysWeather();
            Example e=new Example();
            Today t=new Today();
            
            t.setDescription(description);
            
            t.setHumidity(humidity);
            t.setMain(WeatherCondition);
            t.setPressure(pressure);
           
            t.setTemp(temp);
            t.setTempMax(temp_max);
            t.setTempMin(temp_min);
             
            tw.setToday(t);  
            e.setTodaysWeather(tw);
            
         weatherList.add(e);
		return weatherList;
    }
         
} 
