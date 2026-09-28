package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Birthday;
import edu.wctc.distjavazodiac.entity.Fortune;
import edu.wctc.distjavazodiac.entity.Horoscope;
import edu.wctc.distjavazodiac.repository.FortuneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
Random horoscopes from https://cafeastrology.com/dailyhoroscopesall-tomorrow.html
 */
@Service
public class RandomHoroscopeService implements HoroscopeService {
    private final FortuneRepository fortuneRepository;
    private final ZodiacService zodiacService;

    public RandomHoroscopeService(FortuneRepository fortuneRepository, ZodiacService zodiacService) {
        this.fortuneRepository = fortuneRepository;
        this.zodiacService = zodiacService;
    }

    @Override
    public Horoscope getHoroscope(Birthday birthday) {
        String sign;
        if (birthday.getZodiacType().toLowerCase().startsWith("w")) {
            sign = zodiacService.getWesternZodiacSign(birthday);
        } else {
            sign = zodiacService.getEasternZodiacSign(birthday);
        }

        Horoscope hscope = new Horoscope();
        hscope.setSign(sign);

        List<Fortune> allFortunes = new ArrayList<>();
        fortuneRepository.findAll().forEach(allFortunes::add);
        if (allFortunes.isEmpty()) {
            hscope.setHoroscope("");
            return hscope;
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(allFortunes.size());
        hscope.setHoroscope(allFortunes.get(randomIndex).getText());
        return hscope;
    }
}
