package labSession30Jan;

import java.util.Stack;

public class BalancingBrackets {
	
	static boolean checkingBalancedBrackets(String bracketExpression) {
		
		boolean result=false;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<bracketExpression.length();i++) {
			
			char character=bracketExpression.charAt(i);
			if(character=='('||character=='['||character=='{') {
				stack.push(character);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			char c;
			switch(character) {
				case '}':{
					c=stack.pop();
					if(c=='('||c=='[') {
						return false;
					}
					break;
				}
				case ')':{
					c=stack.pop();
					if(c=='['||c=='{')
						return false;
					break;
				}
				case ']':{
					c=stack.pop();
					if(c=='('||c=='{')
						return false;
					break;
				}
			}
			
		}
		return stack.isEmpty();
		//return result;
		
	}
	
	public static void main(String[] args) {
	
		String bracketExpression="[{()}]";
		boolean result=checkingBalancedBrackets(bracketExpression);
		if(result) {
			System.out.println("Entered string is containing balanced brackets");
		}
		else {
			System.out.println("Entered string doesnt contain balanced brackets");
		}
		
	}

}
