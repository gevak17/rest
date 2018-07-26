package com.gevak.rest.service.impl;

import com.gevak.rest.dao.PersonDAO;
import com.gevak.rest.dao.TechDAO;
import com.gevak.rest.dao.UserDAO;
import com.gevak.rest.entity.Person;
import com.gevak.rest.entity.Tech;
import com.gevak.rest.service.FileService;
import com.gevak.rest.util.CsvProcessingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    TechDAO techDAO;

    public void processCsvFile(MultipartFile file) {
        Map<String, List<String>> stringListMap = CsvProcessingUtil.parseCsvFile(file);
        for (List<String> strings: stringListMap.values()){
            String departmentCode = strings.get(0);
            /*Найменування підрозділу*/
            String departmentName= strings.get(1);
            /*Код посади*/
            String positionCode= strings.get(2);
            /*Код ОВТ або МТЗ*/
            String ovtMtzCode= strings.get(3);
            /*Найменування посади ОВТ або МТЗ*/
            String ovtMtzName= strings.get(4);
            /*Код звання*/
            String rankCode= strings.get(5);
            /*Найменування звання*/
            String rankName= strings.get(6);
            /*Кількість штат*/
            String amount= strings.get(7);
            /*Одиниця виміру*/
            String unit= strings.get(8);
            if (strings.get(8).equals("особи")) {
                Person person = new Person();
                person.setAmount(amount);
                person.setDepartmentCode(departmentCode);
                person.setDepartmentName(departmentName);
                person.setObtMtzCode(ovtMtzCode);
                person.setObtMtzName(ovtMtzName);
                person.setPositionCode(positionCode);
                person.setRankCode(rankCode);
                person.setRankName(rankName);
                person.setUnit(unit);
                personDAO.save(person);
            }
            if (strings.get(8).equals("штуки")) {
                Tech tech = new Tech();
                tech.setAmount(amount);
                tech.setDepartmentCode(departmentCode);
                tech.setDepartmentName(departmentName);
                tech.setObtMtzCode(ovtMtzCode);
                tech.setObtMtzName(ovtMtzName);
                tech.setPositionCode(positionCode);
                tech.setRankCode(rankCode);
                tech.setRankName(rankName);
                tech.setUnit(unit);
                techDAO.save(tech);
            }
        }
    }

    @Override
    public void save(String departmentCode, String departmentName, String positionCode, String ovtMtzCode, String ovtMtzName, String rankCode, String rankName, String amount, String unit) {
        Person person = new Person(departmentCode, departmentName, positionCode, ovtMtzCode, ovtMtzName, rankCode, rankName, amount, unit);
        personDAO.save(person);
    }
}
