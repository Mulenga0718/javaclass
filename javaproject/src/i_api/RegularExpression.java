package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^	 뒷 문자로 시작  
		 * $	 앞 문자로 종료		
		 * . 	 임의의 문자(줄바꿈 제외)	
		 * * 	 앞 문자가 0개 이상 	
		 * + 	 앞 문자가 1개 이상 		
		 * ? 	 앞 문자가 없거나 1개 
		 * [] 	 문자의 집합이나 범위([a-z]:a부터 z까지, [^a-z]:a부터 z가 아닌 것)
		 * {} 	 앞 문자의 개수({2}:2개, {2,4}:2개 이상 4개 이하)
		 * | 	 OR 연산
		 * \s	 공백, 탭, 줄바꿈
		 * \S	 공백, 탭, 줄바꿈이 아닌 문자
		 * \w	 알파벳이나 숫자
		 * \W	 알파벳이나 숫자가 아닌 문자 
		 * \d	 숫자
		 * \D 	 숫자가 아닌 문자
		 * (?i)  뒷 문자의 대소문자 구분 안함
		 * \	 정규표현식에서 사용되는 특수문자 표현 
		 */
	
		String str = "abc123";
//		String regex = "[a-z]{3}[0-9]{1,3}";
//		String regex = "[a-z0-9]+"; //a-z 또는 0-9까지의 숫자가 한개 이상 
		String regex = "\\w*";
		Pattern p = Pattern.compile(regex);	
		Matcher m = p.matcher(str);
		
		System.out.println(m.matches());

		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요. 
		
		String id = "[a-z0-9]{5,20}\\W{1,5}";
		String ph = "[0-9]{9,11}";
		String email = "[a-z0-9]{4,20}\\@{1,1}\\.{1,1}";
		
		// id : [a-z0-9]{5,20}
		// ph : ^0\\d{1,3}-\\d{3,4}-\\d{4}
		// email : [a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?!)(com|net|org|([a-z]{2}\\.kr))$
		
		str ="dkrnq@naver.com"; 
		 p = Pattern.compile(str);	
		 m = p.matcher(email);
		
		System.out.println(m.matches());
		
		
		
		
		
		
		
	}
}
