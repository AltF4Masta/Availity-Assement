package main.java;

import java.util.Stack;

public class LispValidator {
	Stack<String> stack = new Stack<String>();
	public boolean validate(String str) {
		if(str.length() <=1 ) {return false; }
		
		for(int i=0; i < str.length(); i++) {
			if("(".equals(str.substring(i, i+1))) {
				stack.push("(");
			}
			else if(")".equals(str.substring(i, i+1))) {
				if(stack.empty()) { return false; }
				else {
					stack.pop();
				}
			}
		}		
		if(stack.empty()) { return true; }
		else { return false; }
	}
}
