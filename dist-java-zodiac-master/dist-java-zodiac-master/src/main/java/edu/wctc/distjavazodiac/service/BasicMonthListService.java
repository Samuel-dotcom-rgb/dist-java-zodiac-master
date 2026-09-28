package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Month;
import edu.wctc.distjavazodiac.repository.MonthRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicMonthListService implements MonthListService {
    private final MonthRepository monthRepository;

    public BasicMonthListService(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    @Override
    public List<Month> getMonths() {
        List<Month> months = new ArrayList<>();
        monthRepository.findAll().forEach(months::add);
        return months;
    }
}
