package com.yiibai.tutorial.spring.helloworld;

public class HelloWorldService {

	private HelloWorld helloWorld;
	
	private HelloWorld hello;
	  
    public HelloWorldService() {
  
    }
   //��һ��helloWorld��get set ����
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
  
    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
    //�ڶ���hello��get set ����
    public void setHello(HelloWorld helloWorld) {
        this.hello = helloWorld;
    }
  
    public HelloWorld getHello() {
        return this.hello;
    }
}
