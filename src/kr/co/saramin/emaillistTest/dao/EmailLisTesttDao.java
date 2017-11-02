package kr.co.saramin.emaillistTest.dao;

import java.util.List;

import kr.co.saramin.emaillist.dao.EmailListDao;
import kr.co.saramin.emaillist.vo.EmailListVo;

public class EmailLisTesttDao {
	
	public static void main (String[] args) {
		EmailListDao ed = new EmailListDao();
		List<EmailListVo> list = ed.getList();
		
		for (EmailListVo emailListVo : list) {
			
		}
	}
}
