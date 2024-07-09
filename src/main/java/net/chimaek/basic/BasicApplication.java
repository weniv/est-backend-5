package net.chimaek.basic;


import net.chimaek.day0709.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "net.chimaek.day0709")
public class BasicApplication {

    @Autowired
    @Qualifier("sendMessage")
    Message message;

    public static void main(String[] args) {

    }

}