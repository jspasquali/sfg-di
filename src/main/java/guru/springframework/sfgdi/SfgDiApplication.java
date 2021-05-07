package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterBasedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.controllers.MyController;

@SpringBootApplication
public class SfgDiApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

    I18nController i18nController = (I18nController)ctx.getBean("i18nController");
    System.out.println(i18nController.sayHello());

    System.out.println("----------- Primary");
    MyController controller = (MyController)ctx.getBean("myController");
    System.out.println(controller.sayHello());

    System.out.println("----------- Property");
    PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
    System.out.println(propertyInjectedController.getGreeting());

    System.out.println("----------- Setter");
    SetterBasedController setterBasedController = (SetterBasedController) ctx.getBean("setterBasedController");
    System.out.println(setterBasedController.getGreeting());

    System.out.println("----------- Constructor");
    ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
    System.out.println(constructorInjectedController.getGreeting());
  }

}
