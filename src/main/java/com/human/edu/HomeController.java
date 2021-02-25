package com.human.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.MemberService;
import com.human.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/member_delete",method=RequestMethod.POST)
	public String member_delete(MemberVO memberVO) throws Exception {
		String userid = memberVO.getUserid();
		memberService.memberDelete(userid);
		return "redirect:/";
	}
	
	@RequestMapping(value="/member_update",method=RequestMethod.POST)
	public String member_update(MemberVO memberVO) throws Exception {
		memberService.memberUpdate(memberVO);
		return "redirect:/";
	}
	@RequestMapping(value="/member_insert",method=RequestMethod.POST)
	public String member_insert(MemberVO memberVO) throws Exception {
		memberService.memberInsert(memberVO);
		return "redirect:/";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//멤버 조회 리스트 모델을 이용해서 변수값(오브젝트)을 전송(아래)
		model.addAttribute("memberList", memberService.memberSelect());
		return "home";
	}
	
}
