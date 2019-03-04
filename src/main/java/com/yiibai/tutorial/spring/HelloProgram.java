package com.yiibai.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yiibai.tutorial.spring.helloworld.HelloWorld;
import com.yiibai.tutorial.spring.helloworld.HelloWorldService;
import com.yiibai.tutorial.spring.helloworld.impl.SpringHelloWorld;

public class HelloProgram {

	public static void main(String[] args) {
        
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
         
        HelloWorldService service =
             (HelloWorldService) context.getBean("helloWorldService");
          
       HelloWorld hw= service.getHelloWorld();
       HelloWorld hws= service.getHello();
         
       hw.sayHello();
       hws.sayHello();
       hw.sayLove();
       hws.sayLove();
       //SpringHelloWorld sh=(SpringHelloWorld)context.getBean("springHelloWorld");
    
	   //sh.sayHello();
	}
}
