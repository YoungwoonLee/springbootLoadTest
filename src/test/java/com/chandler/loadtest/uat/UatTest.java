package com.chandler.loadtest.uat;

import static org.assertj.core.api.Assertions.assertThat;

import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//모든 요청의 response delay time과 성공 상태를 캡쳐하는 애노테이션 =>ZeroCodeUnitRunner
@RunWith(ZeroCodeUnitRunner.class)
//properties를 읽어서 세팅하기 위한 애노테이션 
@TargetEnv("loadtest.properties")
public class UatTest { //User Acceptance Testing (UAT)

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 임시로 구글로 쏴서 응답 상태코드를 받는 테스트 코드... 
     */
    @Test
    public void should_get_google_com() {
        ResponseEntity<String> responseDtoResponse = 
                                        restTemplate.getForEntity("http://www.google.com", String.class);

        assertThat(responseDtoResponse.getStatusCode().value()).isEqualTo(200);
    }
}