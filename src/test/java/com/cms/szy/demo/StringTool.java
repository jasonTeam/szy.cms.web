package com.cms.szy.demo;

public final class StringTool {
	
	public static void main(String[] args){
		String s = "15267151846,,15267151846,15267151846";
		String[] str = s.split(",");
		
		for(String ss : str ){
			System.out.println(ss.trim());
		}
		
		String ss = "nickNameDsdsf（主播anchorId）存在竞猜异常！请立即核对。";
		String sss = ss.replace("nickName", "沈字样");
		System.out.println(sss);
		
		
		
	}
	
	
	
}
