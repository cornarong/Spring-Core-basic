package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    // * MyLogger의 scope는 request이다. : 웹 스코프(request) : 웹 요청 시 생성 및 초기화 된다.
    // 따라서 의존성(DI) 주입 시점에 MyLogger을 주입받을 수 없다.

    // 1. Provider 사용
    // 의존성(DI) 주입 시점에 MyLogger을 조회할 수 있는 provider을 제공 받는다.
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    // 2. proxyMode 사용
    // 의존성(DI) 주입 시점에 MyLogger을 가짜 프록시로 생성하여 등록한다. (provider보다 깔끔함.)
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        // request 웹 스코프이기 떄문 컨트롤러 호출 시점에 MyLogger을 생성 및 초기화 한다.

        // Provider 사용시
//        MyLogger myLogger = myLoggerProvider.getObject();

        String requestURI = request.getRequestURI();
        myLogger.setRequestURL(requestURI);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
