package org.zerock.persistance;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository; //스프링의 빈으로 인식한다.

@Repository //스프링의 빈으로 인식한다.
public class TimeDAO {
	
	@Inject
	private SqlSessionTemplate session; //try catch 안하는것 //템플릿은 없으니까 inject로 받아버린다.
//
//	public void setSession(SqlSessionTemplate session) {
//		this.session = session;
//	}
	
	public String getTime(){
		
		return session.selectOne("org.zerock.TimeMapper.getTime");
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
