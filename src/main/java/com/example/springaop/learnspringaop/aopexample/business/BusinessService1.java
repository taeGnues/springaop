package com.example.springaop.learnspringaop.aopexample.business;

import com.example.springaop.learnspringaop.aopexample.annotations.TrackTime;
import com.example.springaop.learnspringaop.aopexample.data.DataService1;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BusinessService1 {
    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.retrieveData();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(data).max().orElse(0);
    }
}
