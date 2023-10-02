package com.achrefdkhailia.example.batch;

import com.achrefdkhailia.example.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();
    private static final Map<String, String> EXPERIENCE_YEARS =
            new HashMap<>();

    public Processor() {
        DEPT_NAMES.put("001", "DEV");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Business");
        DEPT_NAMES.put("004", "Leading Technologies");

        EXPERIENCE_YEARS.put("6","6 ans d'experience");
        EXPERIENCE_YEARS.put("5","5 ans d'experience");
        EXPERIENCE_YEARS.put("4","4 ans d'experience");
        EXPERIENCE_YEARS.put("8","8 ans d'experience");
        EXPERIENCE_YEARS.put("13","13 ans d'experience");
        EXPERIENCE_YEARS.put("14","14 ans d'experience");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        String dept = DEPT_NAMES.get(deptCode);
        String anneeExp = EXPERIENCE_YEARS.get(user.getExperience());
        user.setTime(new Date());
        user.setDept(dept);
        user.setExperience(anneeExp);
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
