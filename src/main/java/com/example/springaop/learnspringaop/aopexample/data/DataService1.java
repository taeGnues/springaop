package com.example.springaop.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
    public int[] retrieveData(){
        return new int[] {11,22,33,44,55};
    }
} // db와 통신해서 필요한 데이터를 반환
