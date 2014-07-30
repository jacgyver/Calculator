package application.view;

import java.util.Stack;

import com.sun.javafx.applet.ExperimentalExtensions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
	@FXML
	private Button one;
	@FXML
	private Button two;
	@FXML
	private Button three;
	@FXML
	private Button four;
	@FXML
	private Button five;
	@FXML
	private Button six;
	@FXML
	private Button seven;
	@FXML
	private Button eight;
	@FXML
	private Button nine;
	@FXML
	private Button zero;
	@FXML
	private Button plus;
	@FXML
	private Button minus;
	@FXML
	private Button multiple;
	@FXML
	private Button divide;
	@FXML
	private Button ac;
	@FXML
	private Button equal;

	@FXML
	private TextField bufferTF;
	@FXML
	private TextField displayTF;
	
	
	private String displayTemp = null;
	private boolean checkedAC = false;
	
	private void displayTextField(String text) {
		if (checkedAC == true) {		
			displayTF.setText(text);
			checkedAC = false;
		}
		else
			displayTF.setText(displayTF.getText().concat(text));
	}
	
	
	private Stack<Character> stack1 = new Stack<Character>();
	private Stack<Double> stack2 = new Stack<Double>();

	private int calculate() {
		int intResult = 0;
		String result = "";
		String expression = displayTF.getText();
		
		for (int i=0;i<expression.length();i++) {
			char ch = expression.charAt(i);
			
			if (ch>='0' && ch <= '9' || ch == '.')
				result += ch;
			else if ("+-*/()".contains(String.valueOf(ch))) {
				result += ' ';
				if (stack1.isEmpty())
					stack1.push(ch);
				else if (ch == '(') {
					stack1.push(ch);
				}
				else if (ch == ')') {
					while (!stack1.isEmpty()) {
						char t = stack1.pop();
						if (t=='(') break;
						result += t;
					}
				}
			}
			else {
				while (!stack1.isEmpty() && getPriority(stack1.peek()) >= getPriority(ch)) {
					result += stack1.pop();
				}
				stack1.push(ch);
			}
		}
		
		while (!stack1.isEmpty()) {
			result += stack1.pop();
			System.out.println(expression + " : " + result);
		}

		for (int i=0;i<result.length();i++) {
			char t = result.charAt(i);
			if (t>='0' && t<='9' || t == '.' ) {
				String temp = String.valueOf(t);
				while (i<result.length()) {
					t=result.charAt(++i);
					if (!(t>='0' && t<='9'||t == '.')) {
						--i;
						break;
					}
					temp += t;
				}
				
				System.out.println("Double.parseDouble(temp) : " + Double.parseDouble(temp));
				stack2.push(Double.parseDouble(temp));
			}
			else if ("+-*/()".contains(String.valueOf(t))) {
				if (!stack2.isEmpty()) {
					System.out.println(stack2.size());
					double n1 = stack2.pop();
					double n2 = stack2.pop();
					
					double r=0;
					switch(t) {
						case '+' :
							r=n2+n1;
							break;
						case '-' :
							r=n2-n1;
							break;
						case '*' :
							r=n2*n1;
							break;
						case '/' :
							r=n2/n1;
							break;
						default :
							r = 0;
					}
					stack2.push(r);
					intResult = new Double(r).intValue(); 
				}
			}
		}
		return  intResult;
	}

	
	private int getPriority(char op) {
		int result = 0;
		switch (op) {
			case '+' :
			case '-' :
				result = 1;
				break;
			case '*' :
			case '/' :
				result = 2;
				break;
			default :
				result = 0;
		}
		return result;
	}

	@FXML
	public void initialize() {
		System.out.println("initialize pressed");
		zero.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(zero.getText());
			}

		});

		one.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(one.getText());
			}
		});

		two.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(two.getText());
			}
		});

		three.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(three.getText());
			}
		});

		four.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(four.getText());
			}
		});

		five.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(five.getText());
			}
		});

		six.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(six.getText());
			}
		});

		seven.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(seven.getText());
			}
		});

		eight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(eight.getText());
			}
		});

		nine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(nine.getText());
			}
		});

		plus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(plus.getText());
			}
		});
		minus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(minus.getText());
			}
		});
		multiple.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(multiple.getText());
			}
		});
		divide.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTextField(divide.getText());
			}
		});

		
		ac.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayTF.clear();
				displayTF.setText("0");
				checkedAC = true;
				
			}
		});

		equal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//if (displayTF.getText().equals("0")) 
				bufferTF.setText(displayTF.getText().concat(" = "));
				displayTF.setText(String.valueOf(calculate()));
				
			}

		});

		
	}
	@FXML
	public void selectControls() {

	}	
}
