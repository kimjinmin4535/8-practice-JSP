<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/* inactiveToday 매개변수 값 얻기(체크박스 폼값) 
	[오늘 하루 열지 않음] 체크박스를 체크했다면 이 값으로 "1"이 전달됨*/
	String chkVal = request.getParameter("inactiveToday");		
	
	if (chkVal != null && chkVal.equals("1")){		/* 값이 1이면 쿠키를 생성해 응답 객체에 추가 */
		/* 이름이 "PopupClose", 값이 "off" 쿠키 생성 */
		Cookie cookie = new Cookie("PopupClose","off");
		cookie.setPath(request.getContextPath());	/* 경로 컨텍스트 루트 설정 */
		cookie.setMaxAge(60*60*24); 	/* 유지 기간 하루인 쿠키 설정 */
		response.addCookie(cookie); 	/* 응답 객체에 추가 */
		out.print("쿠키 : 하루 동안 열지 않음");	/* 출력문자열은 success : function(resData)로 콜백함 */
	}
%>