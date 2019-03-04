# Spring
spring框架学习和使用

核心：IOC（依赖注入）和AOP（面向切面编程）

第一步 用Maven添加Spring框架需要的Jar包

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.yiibai</groupId>
  <artifactId>HelloSpring</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies>
        <!-- Spring Core -->
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-core -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.1.4.RELEASE</version>
        </dependency>
         
        <!-- Spring Context -->
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.1.4.RELEASE</version>
        </dependency>
         
    </dependencies>
</project>

第二步 我们创建接口以及实现接口的实体类
接口 HelloWorld：
public interface HelloWorld {
	public void sayHello();
	public void sayLove();
}

服务Service:

package com.yiibai.tutorial.spring.helloworld;

public class HelloWorldService {

  //（字段）HelloWorld接口类型
	private HelloWorld helloWorld;
	  
   //第一个helloWorld的get set 方法 特别注意：helloWorld的get set方法必须同名
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
  
    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
}

实体类SpringHelloWorld：
package com.yiibai.tutorial.spring.helloworld.impl;

import com.yiibai.tutorial.spring.helloworld.HelloWorld;

public class SpringHelloWorld implements HelloWorld{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		 System.out.println("Spring Say Hello!!");
		   
	}      
}

实体类StrutsHelloWorld：
package com.yiibai.tutorial.spring.helloworld.impl;

import com.yiibai.tutorial.spring.helloworld.HelloWorld;

public class StrutsHelloWorld implements HelloWorld {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Struts Say Hello!!");
		
	}
}

第三步 ：最重要的一步（IOC依赖注入） 通过XML文件 进行依赖注入

<?xml version="1.0" encoding="UTF-8"?>
<!--通用头格式-->
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd">
  <!--id:表示bean名 class：这个bean的路径 -->
    <bean id="springHelloWorld"
        class="com.yiibai.tutorial.spring.helloworld.impl.SpringHelloWorld"></bean>
    <bean id="strutsHelloWorld"
        class="com.yiibai.tutorial.spring.helloworld.impl.StrutsHelloWorld"></bean> 
    <!--property name :表示这个服务中的一个字段 ref:注入strutsHelloWorld类-->
    <bean id="helloWorldService"
        class="com.yiibai.tutorial.spring.helloworld.HelloWorldService">
        <property name="helloWorld" ref="strutsHelloWorld"/>
    </bean>
  
</beans>

第四步：

执行

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
           
       hw.sayHello();
       //SpringHelloWorld sh=(SpringHelloWorld)context.getBean("springHelloWorld");
    
	   //sh.sayHello();
	}
}
//最后的结果应该是 ：Struts Say Hello!!
