package kr.ensmart.demo.mybatisbatch.app.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;
import kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper;
import kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper2;
import kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper3;
import kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleMapper;

@Service
public class SampleService {
	private static final int rows = 20000; 

	@Autowired
	SampleMapper sampleMapper;
	
	@Autowired
	SampleBatchMapper sampleBatchMapper;
	
	@Autowired
	SampleBatchMapper2 sampleBatchMapper2;

	@Autowired
	@Qualifier("db1SqlSessionTemplateBatch")
    private SqlSession db1SqlSessionTemplateBatch;
    
	@Autowired
	SampleBatchMapper3 sampleBatchMapper3;

	@Transactional()
	void insertSamples() {
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		for (SampleParam sampleParam : sampleParamList) {
			sampleMapper.insertSample(sampleParam);
		}

	}
	
	@Transactional()
	void insertSamplesBatch() throws Exception {
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		sampleBatchMapper.insertSample(sampleParamList);

	}
	
	@Transactional()
	void insertSamplesBatch2() throws Exception {
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		sampleBatchMapper2.insertSample(sampleParamList);

	}
	
	@Transactional(rollbackFor=Exception.class)
	void insertSamplesBatch2Exception() throws Exception {
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		sampleBatchMapper2.insertSampleException(sampleParamList);

	}
	
	@Transactional()
	void insertSamplesBatch3() throws Exception {
		List<SampleParam> sampleParamList = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			sampleParamList.add(SampleParam.builder().name(i + " name").description(i+ " description").build());
		}
		
		for (SampleParam sampleParam : sampleParamList) {
			sampleBatchMapper3.insertSample(db1SqlSessionTemplateBatch, sampleParam);
		}

	}
	
}
