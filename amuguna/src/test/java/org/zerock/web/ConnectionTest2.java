package org.zerock.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.persistance.TimeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) //location은 파일의 위치를 말한다.
//경로를 다른곳으로 하면 이상한곳으로 뜬다. //**두개들어가면 그 밑에 있는거면 아무거나 가능하다고 함.(하위경로는 어느거나 가능하다)
//TEST 스프링을 로딩해서 application context를 실행한다; TEST 추가해서 가능한 기능이다.
public class ConnectionTest2 {
		
	private static Logger logger
	= Logger.getLogger(ConnectionTest2.class);
	
	@Inject
	private DataSource ds;
	
	@Inject
	ApplicationContext ctx; //스프링의 메트릭스다
	
	@Inject
	SqlSessionFactory sqlFactory;
	
	@Inject
	TimeDAO dao;
	
	@Test
	public void testGetTime(){
		
		
		logger.info("====================");
		
		logger.info(dao.getTime());
		
		logger.info("====================");
		
		
	}
	
	
	@Test
	public void testSession(){
		
		SqlSession sess = sqlFactory.openSession();
		
		logger.info(sess);
		
		String time = sess.selectOne("org.zerock.TimeMapper.getTime");
		
		logger.info("====================");
		logger.info(time);
		logger.info("====================");
		
		sess.close();
	}

	@Test
	public void testCtx(){
		logger.info(ctx);
		
		Object obj = ctx.getBean("sqlSessionFactory"); //getbean object로 나타낸다. -> 해주고 inject해준다.
		
		logger.info(obj);
		
	}
	
	@Test
	public void testLoading(){
		
		logger.info("test Loading");
		
		logger.info(ds);
		
		try {
			Connection con = ds.getConnection();
			logger.info(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
