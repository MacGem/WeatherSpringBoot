package pl.maciek.srpingBoot.controller;

import org.apache.log4j.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import pl.maciek.srpingBoot.jsonweather.WeatherInfo;
import pl.maciek.srpingBoot.model.Appli;
import pl.maciek.srpingBoot.model.Article;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by macie on 26.08.2017.
 */
@Controller
public class WebController  {

//
//    @GetMapping("/")
//    public String hello(){
//        return "hello";
//    }
//
//    String name = "maciek";
//
//    @ResponseBody
//    @GetMapping("/hello")
//    public String helloname(){
//        return "HELLLLLO" + name;
//    }
    @Autowired
    private Appli appli;


    @GetMapping("/add")
    public String add() {
        return "article/add";
    }

//    @GetMapping("/show")
//    public String show(@ModelAttribute Article article, ModelMap modelMap){
//        modelMap.addAttribute("article", article);
//        return "article/show";
//    }

    @GetMapping("/show")
    public String show(@RequestParam ("city") String city, ModelMap modelMap){
        modelMap.addAttribute("city", city);
//        System.out.println(city);
        WeatherInfo weatherInfo = appli.backWeather(city);
        modelMap.addAttribute("temp",weatherInfo.getMain().getTemp());
        return "article/show";
    }
}
