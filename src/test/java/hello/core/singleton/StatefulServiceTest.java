package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    public void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        statefulService statefulService1 = ac.getBean(statefulService.class);
        statefulService statefulService2 = ac.getBean(statefulService.class);

        // ThreadA : A사용자가 10000원을 주문.
        int userAPrice = statefulService1.order("userA",10000);
        // ThreadA : B사용자가 20000원을 주문.
        int userBPrice = statefulService2.order("userB",20000);

        // ThreadA : 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();

        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public statefulService statefulService(){
            return new statefulService();
        }
    }
}
