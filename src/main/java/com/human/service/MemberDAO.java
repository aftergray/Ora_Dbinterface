package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.MemberVO;

@Repository
public class MemberDAO {
	@Inject
	private SqlSession sqlSession;
	
	public void memberInsert(MemberVO memberVO) throws Exception {
		sqlSession.insert("sampleMapper.memberInsert", memberVO);
	}
	
	public List<MemberVO> memberSelect() throws Exception {
		return sqlSession.selectList("sampleMapper.memberSelect");
	}
	
	public MemberVO memberView(String userid) throws Exception {
		return sqlSession.selectOne("sampleMapper.memberView", userid);
	}
	
	public void memberUpdate(MemberVO memberVO) throws Exception {
		sqlSession.update("sampleMapper.memberUpdate", memberVO);
	}
	
	public void memberDelete(String userid) throws Exception {
		sqlSession.delete("sampleMapper.memberDelete", userid);
	}
}
