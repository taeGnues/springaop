package com.example.springaop.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
    public int[] retrieveData(){
        return new int[] {111,222,333,444,555};
    }
} // db와 통신해서 필요한 데이터를 반환
