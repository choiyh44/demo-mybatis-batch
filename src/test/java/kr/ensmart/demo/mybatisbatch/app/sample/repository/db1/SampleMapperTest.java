package kr.ensmart.demo.mybatisbatch.app.sample.repository.db1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleDto;
import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SampleMapperTest {
	@Autowired
	SampleMapper sampleMapper;

	@Test
	void sampleList() {
		List<SampleDto> result = sampleMapper.selectAllSamples();
		
		log.debug("result: {}", result);
		
		assertNotNull(result);
	}

	@Test
	void insertSample() {
		int rows = 100000;
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		Instant start = Instant.now();
		for (SampleParam sampleParam : sampleParamList) {
			sampleMapper.insertSample(sampleParam);
		}
		Instant end = Instant.now();
		log.info("duration: {} ms", Duration.between(start, end).toMillis());
		
	}

}
