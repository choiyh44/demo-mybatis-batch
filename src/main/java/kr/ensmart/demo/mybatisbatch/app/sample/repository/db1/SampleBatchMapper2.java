package kr.ensmart.demo.mybatisbatch.app.sample.repository.db1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;

@Repository
public class SampleBatchMapper2 {
	
	@Autowired
	@Qualifier("db1SqlSessionTemplateBatch")
    private SqlSession db1SqlSessionTemplateBatch;
    
	public void insertSample(List<SampleParam> sampleParamList) {
		for (SampleParam sampleParam: sampleParamList) {
			db1SqlSessionTemplateBatch.update("kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper.insertSample", sampleParam);
		}
	}

	public void insertSampleException(List<SampleParam> sampleParamList) throws Exception {
		SampleParam sampleParam; 
		for ( int i = 0; i < sampleParamList.size(); i++) {
			sampleParam = sampleParamList.get(i);
			db1SqlSessionTemplateBatch.update("kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper.insertSample", sampleParam);
			if (i == 1000) {
				throw new Exception("XXXXXXXXXXXXXXX");
			}
		}
	}

}
