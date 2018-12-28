package com.qmtv.core;

import java.io.FileWriter;
import java.io.IOException;

import com.aliyun.odps.Instance;
import com.aliyun.odps.Instances;
import com.aliyun.odps.Odps;
import com.aliyun.odps.OdpsException;
import com.aliyun.odps.Resource;
import com.aliyun.odps.Resources;
import com.aliyun.odps.Table;
import com.aliyun.odps.Tables;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;

public class MaxCompute {
	public static void main(String[] args) throws OdpsException, IOException {
		
		//配置信息
		Account account = new AliyunAccount("LTAIxmIBNoyP2ep4", "J3F4jh4pV6iaqDwClpsEqu1toFSHHS");
		Odps odps = new Odps(account);
		String odpsUrl = "http://service.odps.aliyun.com/api";
		odps.setEndpoint(odpsUrl);
		odps.setDefaultProject("cdnmonitor");
		
		FileWriter fw = new FileWriter("C://Users/Public/Downloads/instance_schema.json",true);
		
		//获取所有表
		Tables tables = odps.tables();
		//遍历表
		for (Table t : tables) {
//			System.out.println(t.getName()+"\n"+t.getJsonSchema());
			
			//写入本地文件
			fw.write(t.getName()+"\n"+t.getJsonSchema()+"\n");
		}
		//关闭文件
		fw.close();
		
		//获取所有实例
//		Instances instances = odps.instances();
//		for (Instance i : instances) {
//			System.out.println(i.getId());
//		}
		
		//获取所有资源(jar包等)
//		Resources resources = odps.resources();
//		for (Resource r: resources) {
//			System.out.println(r.getName());
//		}
	}
}
