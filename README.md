# demo-mybatis-batch
mybatis ExecutorType.BATCH 테스트 프로그램입니다.

DatasourceConfig 와 Mapper 클래스 소스를 확인해 주세요.

ExecutorType.BATCH 사용을 위해서는 SampleBatchMapper2 방식이 가장 적당해 보입니다.
해당 방식 개발 시 Mapper를 interface가 아닌 class로 작성해야 하지만 이는 ExecutorType.BATCH 처리 시 피할 수 없는 것 같습니다.
해당 방식 개발 시 트랜잭션 처리도 동일하게 잘 동작하는 것을 확인했습니다.

*Test 파일로 테스트 했습니다.
