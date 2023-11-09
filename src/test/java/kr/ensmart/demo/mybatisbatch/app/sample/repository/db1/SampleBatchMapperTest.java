package kr.ensmart.demo.mybatisbatch.app.sample.repository.db1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SampleBatchMapperTest {
	@Autowired
	SampleBatchMapper sampleBatchMapper;

	@Test
	void insertSample() throws Exception {
		int rows = 100000;
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		Instant start = Instant.now();
		sampleBatchMapper.insertSample(sampleParamList);
		Instant end = Instant.now();
		log.info("duration: {} ms", Duration.between(start, end).toMillis());
		
	}

}
