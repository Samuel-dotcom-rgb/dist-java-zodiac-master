package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Birthday;
import edu.wctc.distjavazodiac.entity.Horoscope;

public interface HoroscopeService {
    Horoscope getHoroscope(Birthday birthday);
}
