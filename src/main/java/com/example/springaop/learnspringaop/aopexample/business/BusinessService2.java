package com.example.springaop.learnspringaop.aopexample.business;

import com.example.springaop.learnspringaop.aopexample.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BusinessService2 {
    private DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    public int calculateMin() {
        int[] data = dataService2.retrieveData();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(data).min().orElse(0);
    }
}
