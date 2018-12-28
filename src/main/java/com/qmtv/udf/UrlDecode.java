package com.qmtv.udf;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.aliyun.odps.udf.UDF;

public class UrlDecode extends UDF{
	
	public String evaluate(String str) throws UnsupportedEncodingException{
		
		if(str == null || str.equals("")){
			return "";
		}else{
			return URLDecoder.decode(URLDecoder.decode(str, "utf-8"), "utf-8");
		}
		
	}
}
