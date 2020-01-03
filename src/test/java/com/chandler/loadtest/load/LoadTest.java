package com.chandler.loadtest.load;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

import com.chandler.loadtest.uat.UatTest;

// test할 클래스와 메소드를 지정하기 위한 애노테이션
@TestMapping(testClass = UatTest.class, testMethod = "should_get_google_com")
// 부하를 주기위한(쓰레드) 
@LoadWith("loadtest.properties")
// zero code load runner실행 애노테이션
@RunWith(ZeroCodeLoadRunner.class)
public class LoadTest {
// loadtest.properties에 생성된것 처럼 {number.of.threads}개의 스레드를 생성하여 
//	{ramp.up.period.in.seconds}초내에 UatTest를 {loop.count}회 반복 호출한다.
//	예 number.of.threads=10, ramp.up.period.in.seconds=2 이면 
//	2/10 = 0.2 => 200ms간격으로 미친듯이 호출....

/** 현재는 단일테스트지만 여러 tc를 돌리고자 할때 아래처럼 하쟈~~~	
	@TestMappings({
        @TestMapping(testClass = UatTest.class, testMethod = "testGet"),
        @TestMapping(testClass = UatTest.class, testMethod = "testPostGet"),
        @TestMapping(testClass = UatTest.class, testMethod = "testPostGetPutGet"),
        @TestMapping(testClass = UatTest.class, testMethod = "testStress")
	})
*/	
}
