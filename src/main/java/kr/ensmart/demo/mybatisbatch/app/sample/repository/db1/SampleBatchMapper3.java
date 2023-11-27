package kr.ensmart.demo.mybatisbatch.app.sample.repository.db1;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;

@Repository
public class SampleBatchMapper3 {
	
	public void insertSample(SqlSession db1SqlSessionTemplateBatch, SampleParam sampleParam) {
		db1SqlSessionTemplateBatch.update("kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper.insertSample", sampleParam);
	}

}
