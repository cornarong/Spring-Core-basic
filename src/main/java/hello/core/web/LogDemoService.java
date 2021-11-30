package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    // Provider 사용시
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    // proxyMode를 사용하여 의존성 주입시점에 가짜 프록시객체를 등록하고 사용시점에 진짜객체를 사용한다.
    // 따라서 그냥 설정만 해주면 싱글톤처럼 사용할 수 있다.
    private final MyLogger myLogger;

    public void logic(String id) {
        // Provider 사용시
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
