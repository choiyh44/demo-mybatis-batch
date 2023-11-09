package kr.ensmart.demo.mybatisbatch.app.sample.repository.db1;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ensmart.demo.mybatisbatch.app.sample.dto.SampleParam;

@Repository
public class SampleBatchMapper {
	
	@Autowired
	private SqlSessionFactory db1SqlSessionFactory;

	public void insertSample(List<SampleParam> sampleParamList) throws Exception {
		SqlSession sqlSession = null;
		sqlSession = this.db1SqlSessionFactory.openSession(ExecutorType.BATCH);
		try {
			for (SampleParam sampleParam: sampleParamList) {
				sqlSession.insert("kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper.insertSample", sampleParam);
			}
		} catch (Exception e) {
		    sqlSession.rollback();
		    throw e;
		} finally {
			sqlSession.flushStatements(); //남은거 밀어넣고
		    sqlSession.commit();	//커밋!(이때 커넥션 한번!)
		    sqlSession.close();
		}
	}

	public void insertSampleException(List<SampleParam> sampleParamList) throws Exception {
		SqlSession sqlSession = null;
		sqlSession = this.db1SqlSessionFactory.openSession(ExecutorType.BATCH);
		try {
			SampleParam sampleParam; 
			for ( int i = 0; i < sampleParamList.size(); i++) {
				sampleParam = sampleParamList.get(i);
				sqlSession.insert("kr.ensmart.demo.mybatisbatch.app.sample.repository.db1.SampleBatchMapper.insertSample", sampleParam);
				if (i == 1000) {
					throw new Exception("XXXXXXXXXXXXXXX");
				}
			}
		} catch (Exception e) {
		    sqlSession.rollback();
		    throw e;
		} finally {
			sqlSession.flushStatements(); //남은거 밀어넣고
		    sqlSession.commit();	//커밋!(이때 커넥션 한번!)
		    sqlSession.close();
		}
	}

}
