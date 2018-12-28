package com.qmtv.udf;

public class Test {
	public static void main(String[] args) {
		long l = ip2long("223.247.255.255");
		System.out.println(l);  //4294967295
	}
	
	private static int str2Ip(String ip)  {
        String[] ss = ip.split("\\.");
        int a, b, c, d;
        a = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);
        c = Integer.parseInt(ss[2]);
        d = Integer.parseInt(ss[3]);
//        System.out.println((a << 24) | (b << 16) | (c << 8) | d);   //1981548552
        return (a << 24) | (b << 16) | (c << 8) | d;
    }
    
    private static long ip2long(String ip)  {
//    	System.out.println(int2long(str2Ip(ip)));    //1981548552
        return int2long(str2Ip(ip));
    }
    
    private static long int2long(int i) {
        long l = i & 0x7fffffffL;
        if (i < 0) {
            l |= 0x080000000L;
        }
        return l;
    }
}
