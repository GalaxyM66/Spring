package com.yiibai.tutorial.spring.helloworld;

public class HelloWorldService {

	private HelloWorld helloWorld;
	
	private HelloWorld hello;
	  
    public HelloWorldService() {
  
    }
   //第一个helloWorld的get set 方法
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
  
    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
    //第二个hello的get set 方法
    public void setHello(HelloWorld helloWorld) {
        this.hello = helloWorld;
    }
  
    public HelloWorld getHello() {
        return this.hello;
    }
}
