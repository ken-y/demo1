package com.ken.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        System.out.println(201912/10);
        System.out.println(201912/100);
        System.out.println(201912/1000);
        System.out.println(201912/10000);
    }

}
