package kr.ensmart.demo.mybatisbatch.app.sample.service;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@TestMethodOrder(OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
class SampleServiceTest {
	@Autowired
	SampleService sampleService;

	@Test
	void insertSamples() {
		Instant start = Instant.now();
		
		sampleService.insertSamples();
		
		Instant end = Instant.now();
		log.info("insertSamples duration: {} ms", Duration.between(start, end).toMillis());
	}

	@Test
	void insertSamplesBatch() throws Exception {
		Instant start = Instant.now();
		
		sampleService.insertSamplesBatch();
		
		Instant end = Instant.now();
		log.info("insertSamplesBatch duration: {} ms", Duration.between(start, end).toMillis());
	}

	@Test
	void insertSamplesBatch2() throws Exception {
		Instant start = Instant.now();
		
		sampleService.insertSamplesBatch2();
		
		Instant end = Instant.now();
		log.info("insertSamplesBatch2 duration: {} ms", Duration.between(start, end).toMillis());
	}

	@Test
	void insertSamplesBatch2Exception() throws Exception {
		Instant start = Instant.now();
		
		sampleService.insertSamplesBatch2Exception();
		
		Instant end = Instant.now();
		log.info("insertSamplesBatch2 duration: {} ms", Duration.between(start, end).toMillis());
	}

}
