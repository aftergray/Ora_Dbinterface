package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public void memberInsert(MemberVO memberVO) throws Exception {
		// DAO호출
		memberDAO.memberInsert(memberVO);
	}

	@Override
	public List<MemberVO> memberSelect() throws Exception {
		// DAO호출
		return memberDAO.memberSelect();
	}

	@Override
	public MemberVO memberView(String userid) throws Exception {
		// DAO호출
		return memberDAO.memberView(userid);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		// DAO호출
		memberDAO.memberUpdate(memberVO);
	}

	@Override
	public void memberDelete(String userid) throws Exception {
		// DAO호출
		memberDAO.memberDelete(userid);
	}

}
