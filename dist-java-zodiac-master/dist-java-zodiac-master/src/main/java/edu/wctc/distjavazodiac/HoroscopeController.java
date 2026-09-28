package edu.wctc.distjavazodiac;

import edu.wctc.distjavazodiac.entity.Birthday;
import edu.wctc.distjavazodiac.service.HoroscopeService;
import edu.wctc.distjavazodiac.service.MonthListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HoroscopeController {

    private final MonthListService monthListService;
    private final HoroscopeService horoscopeService;

    @Autowired
    public HoroscopeController(MonthListService monthListService, HoroscopeService horoscopeService) {
        this.monthListService = monthListService;
        this.horoscopeService = horoscopeService;
    }

    @PostMapping("/get-horoscope")
    public String processForm(@ModelAttribute Birthday bday,
                              Model model) {
        model.addAttribute("hs", horoscopeService.getHoroscope(bday));

        return "horoscope";
    }

    @GetMapping("/enter-birthday")
    public String showForm(Model model) {
        model.addAttribute("monthList", monthListService.getMonths());

        Birthday formDefaults = new Birthday();
        formDefaults.setYear(1975);
        formDefaults.setMonth(9);
        formDefaults.setDay(29);
        formDefaults.setZodiacType("Eastern");
        model.addAttribute("birthday", formDefaults);
        return "birthday-form";
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }
}
