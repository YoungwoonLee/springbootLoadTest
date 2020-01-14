package com.chandler.loadtest.uat;

import static org.assertj.core.api.Assertions.assertThat;

import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.chandler.loadtest.AppConfig;
import com.chandler.loadtest.share.Shared;
import com.chandler.loadtest.testrunnet.ZeroCodeSpringbootJUnit4Runner;

@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//모든 요청의 response delay time과 성공 상태를 캡쳐하는 애노테이션 =>ZeroCodeUnitRunner
//@RunWith(ZeroCodeUnitRunner.class)
@RunWith(ZeroCodeSpringbootJUnit4Runner.class) //DI 안되서 커스터마이징한 테스트러너..
//properties를 읽어서 세팅하기 위한 애노테이션 
//@TargetEnv("loadtest.properties")
@ContextConfiguration(classes = {AppConfig.class})
public class UatTest { //User Acceptance Testing (UAT)

//    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RestTemplate restTemplate;
    Shared share = Shared.getInstance();
    
    @Before
    public void setUp() {
    	System.out.println("@~~ before @.@");
    }
    /**
     * 임시로 구글로 쏴서 응답 상태코드를 받는 테스트 코드... 
     */
    @Test
    public void shouldGetGoogleCom() {
        ResponseEntity<String> responseDtoResponse = 
                                        restTemplate.getForEntity("http://www.google.com", String.class);

        assertThat(responseDtoResponse.getStatusCode().value()).isEqualTo(200);
    }
    
    /**
     * 멀티 테스트 환경하에서 유니크한 id로 테스트 하고자 함.
     */
    @Test
    public void uniqIdTest() {
    	long id = share.increment();
        ResponseEntity<String> responseDtoResponse = 
                restTemplate.getForEntity("http://127.0.0.1:5801/api/liders/tracksinfos?liderId="+id, String.class);

        assertThat(responseDtoResponse.getStatusCode().value()).isEqualTo(200);
    }
}