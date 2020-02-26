import java.util.Stack;

/**
 *
 * @author zeinab
 */
public class Calculator {
	public String infixToPostfix(String s){
		String postfix = "";
		Stack<Character> statment = new Stack<Character>();
		for(int i=0 ; i< s.length(); i++){
			if(s.charAt(i) == '('){
				statment.push('(');
			}else if(s.charAt(i) == ')'){
				char ch;
				while(!statment.isEmpty() && (ch = statment.peek()) != '('){
					postfix += statment.pop();
				}
				statment.pop();
			}else if(s.charAt(i) == '*' || s.charAt(i) == '/') {
				char ch;
				while(!statment.isEmpty() && ((ch = statment.peek()) == '*' || ch == '/')){
					postfix += statment.pop();
				}
				statment.push(s.charAt(i));
			}else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
				char ch;
				while(!statment.isEmpty() && (ch = statment.peek()) != '('){
					postfix += statment.pop();
				}
				statment.push(s.charAt(i));
			}else{
				postfix += s.charAt(i);
			}
		}
		while(!statment.isEmpty()){
			postfix += statment.pop();
		}
		return postfix;
	}

	public double postfixEval(String postfix){
		Stack<Double> stack = new Stack<Double>();
		for(int i=0 ; i < postfix.length() ; i++){
			char ch = postfix.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				double right = stack.pop();
				double left = stack.pop();
				if(postfix.charAt(i) == '+')
					stack.push(left + right);
				else if(postfix.charAt(i) == '-')
					stack.push(left - right);
				else if(postfix.charAt(i) == '*')
					stack.push(left * right);
				else if(postfix.charAt(i) == '/')
					stack.push(left / right);
			}else{
				stack.push(Double.parseDouble(String.valueOf(postfix.charAt(i))));
			}
		}
		return stack.pop();
	}
}