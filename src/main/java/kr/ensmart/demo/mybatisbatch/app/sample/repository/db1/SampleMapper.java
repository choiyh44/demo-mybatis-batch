package kr.ensmart.demo.mybatisbatch.app.sample.repository.db1;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleDto;
import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;

@Repository
public interface SampleMapper {
	List<SampleDto> selectAllSamples();
	
	void insertSample(SampleParam sampleParam);
	
}
