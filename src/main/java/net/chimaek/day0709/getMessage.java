package net.chimaek.day0709;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class getMessage implements Message {

    @Override
    public void print() {
        System.out.println("Hello, World!2");
    }
}