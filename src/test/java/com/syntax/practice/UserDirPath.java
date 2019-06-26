package com.syntax.practice;

import org.testng.annotations.Test;

public class UserDirPath {

	@Test
	public void printPath() {
		System.out.println(System.getProperty("user.dir"));
		String path=System.getProperty("user.dir");
		//C:\Users\ikoseoglu61\eclipse-workspace\TestNGFramework
		String fulPath=path+"/target/screenshots/fileName.png";
		
	}
}
