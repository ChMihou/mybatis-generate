package com.java.workstudy.study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class filter {
    public static void main(String[] args){
        List<Filters> filtersList = new ArrayList<>();
        for (int i = 0 ; i < 10 ;i++){
            Filters filters = new Filters();
            filters.setName("测试Name："+i);
            filters.setValue("测试Value："+i);
            filtersList.add(filters);
        }
        List<String> stringList = filtersList.stream().map(values->values.value).collect(Collectors.toList());
        System.out.println(stringList);
    }
    public static class Filters{
        public String name;
        public String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
