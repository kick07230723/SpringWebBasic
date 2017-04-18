package org.zerock.persistance;


import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Repository
public class BoardDAO {
	
	@Inject
	private SqlSessionTemplate sess;
	
	public void create(BoardVO vo){
		
		sess.insert("org.zerock.persistance.BoardDAO.create", vo);
	}
	
	
}
